package cl.pinolabs.kevinstore.model.persistence.crud;

import cl.pinolabs.kevinstore.model.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoCrud extends CrudRepository<Producto, Integer> {
}