package cl.pinolabs.kevinstore.model.persistence.repository;

import cl.pinolabs.kevinstore.model.domain.dto.MensajeDTO;
import cl.pinolabs.kevinstore.model.domain.repository.MensajeDTORepository;
import cl.pinolabs.kevinstore.model.persistence.crud.MensajeCrud;
import cl.pinolabs.kevinstore.model.persistence.entity.Mensaje;
import cl.pinolabs.kevinstore.model.persistence.mapper.MensajeMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MensajeRepository implements MensajeDTORepository {

    private final MensajeCrud crud;
    private final MensajeMapper mapper;

    public MensajeRepository(MensajeCrud crud, MensajeMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<MensajeDTO>> findAll() {
        return Optional.of(mapper.toMensajesDTO((List<Mensaje>) crud.findAll()));
    }

    @Override
    public Optional<MensajeDTO> findById(int idMensaje) {

        return crud.findById(idMensaje)
                .map(mapper::toMensajeDTO);
    }

    @Override
    public MensajeDTO save(MensajeDTO mensajeDTO) {
        return mapper.toMensajeDTO(crud.save(mapper.toMensaje(mensajeDTO)));
    }

    @Override
    public void delete(int idMensaje) {
        crud.deleteById(idMensaje);
    }
}