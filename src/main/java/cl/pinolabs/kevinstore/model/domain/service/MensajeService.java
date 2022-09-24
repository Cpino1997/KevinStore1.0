package cl.pinolabs.kevinstore.model.domain.service;

import cl.pinolabs.kevinstore.model.domain.dto.MensajeDTO;
import cl.pinolabs.kevinstore.model.domain.repository.MensajeDTORepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MensajeService {
    private final MensajeDTORepository repo;

    public MensajeService(MensajeDTORepository repo) {
        this.repo = repo;
    }

    public Optional<List<MensajeDTO>> findAll(){
        return repo.findAll();
    }

    public Optional<MensajeDTO> findById(int idMensaje){
        return repo.findById(idMensaje);
    }
    public MensajeDTO save(MensajeDTO mensajeDTO){
        return repo.save(mensajeDTO);
    }

    public boolean delete(int idMensaje){
        return findById(idMensaje)
                .map(mensajeDTO -> {
                    repo.delete(idMensaje);
                    return true;})
                .orElse(false);
    }
}
