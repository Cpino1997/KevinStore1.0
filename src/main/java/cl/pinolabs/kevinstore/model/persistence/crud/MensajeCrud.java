package cl.pinolabs.kevinstore.model.persistence.crud;

import cl.pinolabs.kevinstore.model.persistence.entity.Mensaje;
import org.springframework.data.repository.CrudRepository;

public interface MensajeCrud extends CrudRepository<Mensaje, Integer> {
}
