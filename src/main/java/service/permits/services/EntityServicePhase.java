package service.permits.services;

public interface EntityServicePhase<BaseDomain> {

    BaseDomain beforeSave(BaseDomain entity);

}
