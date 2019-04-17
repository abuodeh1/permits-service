package service.permits.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import service.permits.dto.PermitDTO;
import service.permits.model.permit.Permit;
import service.permits.services.PermitService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping(value = "/api/permit")
public class PermitController extends EntityControllerCRUD<Permit, PermitDTO> {

    @Autowired
    private PermitService permitService;

    @Override
    public Permit buildEntity() {
        return new Permit();
    }

    @Override
    public PermitDTO buildDTO() {
        return new PermitDTO();
    }

}
