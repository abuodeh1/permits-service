package service.permits.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import service.permits.model.permit.Permit;
import service.permits.services.BaseRepository;

@Repository
public interface PermitRepository extends BaseRepository<Permit, Integer>, JpaSpecificationExecutor<Permit> {

}