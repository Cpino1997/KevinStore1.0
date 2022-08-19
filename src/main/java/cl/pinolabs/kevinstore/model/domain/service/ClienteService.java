package cl.pinolabs.kevinstore.model.domain.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import cl.pinolabs.kevinstore.model.domain.dto.ClienteDTO;
import cl.pinolabs.kevinstore.model.domain.repository.ClienteDTORepository;

@Service
public class ClienteService {
    private final ClienteDTORepository repo;

    public ClienteService(ClienteDTORepository repo) {
        this.repo = repo;
    }

    public Optional<List<ClienteDTO>> findAll(){
        return repo.findAll();
    }

    public Optional<ClienteDTO> findById(int idCliente){
        return repo.findById(idCliente);
    }
    public ClienteDTO save(ClienteDTO clienteDTO){
        return repo.save(clienteDTO);
    }

    public boolean delete(int idCliente){
        return findById(idCliente)
                .map(clienteDTO -> {
                    repo.delete(idCliente);
                    return true;})
                .orElse(false);
    }
}