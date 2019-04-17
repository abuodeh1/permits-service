package service.permits.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import service.permits.dto.BaseDTO;
import service.permits.model.BaseEntity;
import service.permits.services.AbstractEntityService;

import java.util.Optional;

public abstract class EntityControllerActivation<T extends BaseEntity, D extends BaseDTO> {

    @Autowired
    AbstractEntityService<T> baseService;

    @GetMapping(value = "/{id}/deactivate")
    public ResponseEntity<D> deactivate(@PathVariable int id) {

        ResponseEntity<D> responseEntity = null;

        Optional<T> sysEntity = baseService.get(id);

        if (sysEntity.isPresent()) {

            T entity = sysEntity.get();

            entity.setId(sysEntity.get().getId());


            entity.setEnabled(false);

            T updatedEntity = baseService.save(entity);

            D dto = buildDTO();

            BeanUtils.copyProperties(updatedEntity, dto,"password");

            responseEntity = new ResponseEntity(dto, HttpStatus.OK);

        } else {

            responseEntity = new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }

        return responseEntity;
    }

    @GetMapping(value = "/{id}/activate")
    public ResponseEntity<D> activate(@PathVariable int id) {

        ResponseEntity<D> responseEntity = null;

        Optional<T> sysEntity = baseService.get(id);

        if (sysEntity.isPresent()) {

            T entity = sysEntity.get();

            entity.setId(sysEntity.get().getId());

            entity.setEnabled(true);

            T updatedEntity = baseService.save(entity);

            D dto = buildDTO();

            BeanUtils.copyProperties(updatedEntity, dto);

            responseEntity = new ResponseEntity(dto, HttpStatus.OK);

        } else {

            responseEntity = new ResponseEntity(HttpStatus.NOT_MODIFIED);
        }

        return responseEntity;
    }
    public abstract T buildEntity();
    public abstract D buildDTO();

}
