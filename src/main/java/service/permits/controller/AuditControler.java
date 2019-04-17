package service.permits.controller;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.hibernate.envers.RevisionType;
import org.hibernate.envers.query.AuditEntity;
import org.hibernate.envers.query.AuditQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import service.audit.AuditQueryResult;
import service.audit.CustomRevision;
import service.permits.model.permit.Permit;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/audit")
public class AuditControler implements Serializable {

    @Autowired
    private EntityManager entityManager;

    @GetMapping(value = "/permit/{id}")
    public List<AuditQueryResult<Permit>> getPermitAudit(@PathVariable String id) {

        List<AuditQueryResult<Permit>> auditQueryResultList = new ArrayList<>();

        AuditReader auditReader = AuditReaderFactory.get(entityManager);
        //AuditQuery query = auditReader.createQuery().forEntitiesAtRevision(Permit.class, 2);

        AuditQuery auditQuery = auditReader.createQuery().forRevisionsOfEntity(Permit.class, false, true);
        auditQuery.add(AuditEntity.id("id").eq(id));
        auditQuery.addOrder(AuditEntity.revisionNumber().desc());

        List result = auditQuery.getResultList();
        result.forEach(rs -> {
            Object[] objects = (Object[]) rs;
            auditQueryResultList.add(new AuditQueryResult(objects[0], (CustomRevision)objects[1], (RevisionType) objects[2]));
        });


        return auditQueryResultList;
    }
}
