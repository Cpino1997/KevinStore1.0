package cl.pinolabs.kevinstore.model.persistence.crud;

import cl.pinolabs.kevinstore.model.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductoCrud extends CrudRepository<Producto, Integer> {
}