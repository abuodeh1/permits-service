package service.permits.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.permits.model.permit.Permit;
import service.permits.repositories.PermitRepository;

@Service
public class PermitService extends AbstractEntityService<Permit> {

    @Autowired
    private PermitRepository permitsRepository;

    @Override
    public PermitRepository getRepository() {
        return permitsRepository;
    }

}

