package service.permits.lookup;


import org.hibernate.envers.Audited;
import org.hibernate.envers.RelationTargetAuditMode;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.Id;

@Audited(targetAuditMode = RelationTargetAuditMode.NOT_AUDITED)
@Transactional(readOnly = true )
@Entity(name="Lookup")
public class Lookup {

    @Id
    private int id;
    private String code;
    private String description;
    private String descriptionAr;

    public Lookup() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionAr() {
        return descriptionAr;
    }

    public void setDescriptionAr(String descriptionAr) {
        this.descriptionAr = descriptionAr;
    }

}
