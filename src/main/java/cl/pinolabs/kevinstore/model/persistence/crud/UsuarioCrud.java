package cl.pinolabs.kevinstore.model.persistence.crud;

import cl.pinolabs.kevinstore.model.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioCrud extends CrudRepository<UserEntity, String> {
    boolean existsByUsername(String username);
}