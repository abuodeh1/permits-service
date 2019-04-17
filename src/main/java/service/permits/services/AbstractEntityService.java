package service.permits.services;

import service.permits.controller.find.QuerySpecification;

import java.util.List;
import java.util.Optional;

public abstract class AbstractEntityService<T> {

    public Optional<T> get(int id){
        return getRepository().findById(id);
    }

    public T save(T entity){

        if(getRepository() instanceof EntityServicePhase) {

            entity = (T)((EntityServicePhase) getRepository()).beforeSave(entity);
        }

        return (T) getRepository().save(entity);
    }

    public boolean delete(int id){

        Optional<T> entity = getRepository().findById(id);

        if (entity.isPresent()) {

            getRepository().delete(entity);

            return true;
        }

        return false;

    }

    public List<T> getAll(){

        return getRepository().findAll();
    }

    public List<T> find(QuerySpecification<T> querySpecification){

        return getRepository().findAll(querySpecification);
    }

    public abstract BaseRepository getRepository();

}
