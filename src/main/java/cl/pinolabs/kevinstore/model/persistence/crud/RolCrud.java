package cl.pinolabs.kevinstore.model.persistence.crud;

import cl.pinolabs.kevinstore.model.persistence.entity.RolEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RolCrud extends CrudRepository<RolEntity, Integer> {

    Optional<RolEntity> findByRolName(String rolNome);
}