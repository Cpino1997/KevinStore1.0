package cl.pinolabs.kevinstore.model.domain.repository;

import java.util.List;
import java.util.Optional;

import cl.pinolabs.kevinstore.model.domain.dto.ClienteDTO;

/**
 * ClienteDTORepository
 */
public interface ClienteDTORepository {

    Optional<List<ClienteDTO>> findAll();
    Optional<ClienteDTO> findById(int idCliente);
    ClienteDTO save(ClienteDTO clienteDTO);
    void delete(int idCliente);
}