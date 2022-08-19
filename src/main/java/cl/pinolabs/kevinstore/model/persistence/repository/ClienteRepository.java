package cl.pinolabs.kevinstore.model.persistence.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import cl.pinolabs.kevinstore.model.domain.dto.ClienteDTO;
import cl.pinolabs.kevinstore.model.domain.repository.ClienteDTORepository;
import cl.pinolabs.kevinstore.model.persistence.crud.ClienteCrud;
import cl.pinolabs.kevinstore.model.persistence.entity.Cliente;
import cl.pinolabs.kevinstore.model.persistence.mapper.ClienteMapper;

@Repository
public class ClienteRepository implements ClienteDTORepository {

    private final ClienteCrud crud;
    private final ClienteMapper mapper;

    public ClienteRepository(ClienteCrud crud, ClienteMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<ClienteDTO>> findAll() {
        return Optional.of(mapper.toClienteDTOs((List<Cliente>) crud.findAll()));
    }

    @Override
    public Optional<ClienteDTO> findById(int idCliente) {

        return crud.findById(idCliente)
                .map(mapper::toClienteDTO);
    }

    @Override
    public ClienteDTO save(ClienteDTO clienteDTO) {
        return mapper.toClienteDTO(crud.save(mapper.toCliente(clienteDTO)));
    }

    @Override
    public void delete(int idCliente) {
        crud.deleteById(idCliente);
    }
}