package cl.pinolabs.kevinstore.model.persistence.crud;

import cl.pinolabs.kevinstore.model.persistence.entity.Venta;
import org.springframework.data.repository.CrudRepository;

public interface VentaCrud extends CrudRepository<Venta, Integer> {
}
