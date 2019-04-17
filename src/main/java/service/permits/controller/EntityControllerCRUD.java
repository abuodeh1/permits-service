package service.permits.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import service.exception.ConflictException;
import service.permits.controller.find.QuerySpecification;
import service.permits.controller.find.SearchCriteria;
import service.permits.dto.BaseDTO;
import service.permits.model.BaseEntity;
import service.permits.services.AbstractEntityService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class EntityControllerCRUD<T extends BaseEntity, D extends BaseDTO> extends EntityControllerActivation<T, D> {

    @Autowired
    AbstractEntityService<T> baseService;

    @PostMapping(value = {"", "/"})
    public ResponseEntity<T> add(@RequestBody D dto) {

        Optional<T> entity = baseService.get(dto.getId());

        if (entity.isPresent()) {

            throw new ConflictException(String.format("The %s already defined.", dto.getId()));
        }

        T newEntity = buildEntity();

        BeanUtils.copyProperties(dto, newEntity);

        modifyDTO(dto);

        T addedUser = baseService.save(newEntity);

        BeanUtils.copyProperties(addedUser, dto, "password");

        return new ResponseEntity(dto, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<T> get(@PathVariable int id) {

        ResponseEntity<T> responseEntity = null;

        Optional<T> entity = baseService.get(id);

        if (entity.isPresent()) {

            D dto = buildDTO();

            BeanUtils.copyProperties(entity.get(), dto, "password");

            modifyDTO(dto);

            responseEntity = new ResponseEntity(dto, HttpStatus.OK);

        } else {

            responseEntity = new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return responseEntity;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity delete(@PathVariable int id) {

        ResponseEntity<T> responseEntity = null;

        Optional<T> entity = baseService.get(id);

        if (entity.isPresent()) {

            baseService.delete(id);

            responseEntity = new ResponseEntity(true, HttpStatus.OK);

        } else {

            responseEntity = new ResponseEntity(false, HttpStatus.NOT_FOUND);
        }

        return responseEntity;

    }

    @PutMapping
    public ResponseEntity<T> update(@RequestBody D dto) {

        ResponseEntity<T> responseEntity = null;

        Optional<T> entity = baseService.get(dto.getId());

        if (entity.isPresent()) {

            T newEntity = buildEntity();

            BeanUtils.copyProperties(dto, newEntity);

            newEntity.setId(entity.get().getId());

            T updatedUser = baseService.save(newEntity);

            BeanUtils.copyProperties(updatedUser, dto, "password");

            responseEntity = new ResponseEntity(dto, HttpStatus.OK);
        }
//        }else{
//
//            responseEntity = new ResponseEntity(HttpStatus.NOT_MODIFIED);
//        }

        return responseEntity;

    }

    @GetMapping()
    public ResponseEntity<List<T>> getAll() {

        List<T> entities = baseService.getAll();

        List<D> dtos = new ArrayList<>();

        entities.stream().forEach(entity -> {
            D dto = buildDTO();
            BeanUtils.copyProperties(entity, dto, "password");
            dtos.add(dto);
        });
        return new ResponseEntity(dtos, HttpStatus.OK);
    }

    @PostMapping(value = "/find")
    public ResponseEntity<List<T>> find(@RequestBody List<SearchCriteria> criteriaList) {

        QuerySpecification<T> querySpecification = new QuerySpecification<>(criteriaList);

        List<T> entities = baseService.find(querySpecification);

        List<D> dtos = new ArrayList<>();

        entities.stream().forEach(entity -> {
            D dto = buildDTO();
            BeanUtils.copyProperties(entity, dto, "password");
            dtos.add(dto);
        });

        return new ResponseEntity(dtos, HttpStatus.OK);
    }

    public abstract T buildEntity();

    public abstract D buildDTO();

    public void modifyDTO(D dto) {
    }
}
