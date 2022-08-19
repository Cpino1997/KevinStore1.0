package cl.pinolabs.kevinstore.model.persistence.crud;

import org.springframework.data.repository.CrudRepository;

import cl.pinolabs.kevinstore.model.persistence.entity.Cliente;

/**
 * ClienteCrud
 */
public interface ClienteCrud extends CrudRepository<Cliente, Integer> {

    
}