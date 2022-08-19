package cl.pinolabs.kevinstore.model.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import cl.pinolabs.kevinstore.model.persistence.entity.Categoria;

public interface CategoriaCrud extends CrudRepository<Categoria, Integer> {
}
