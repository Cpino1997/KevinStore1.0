package cl.pinolabs.kevinstore.model.domain.repository;

import cl.pinolabs.kevinstore.model.domain.dto.MensajeDTO;

import java.util.List;
import java.util.Optional;

public interface MensajeDTORepository {
    Optional<List<MensajeDTO>> findAll();
    Optional<MensajeDTO> findById(int idMensaje);
    MensajeDTO save(MensajeDTO mensajeDTO);
    void delete(int idMensaje);
}
