package cl.pinolabs.kevinstore.model.persistence.repository;

import cl.pinolabs.kevinstore.model.domain.dto.Rol;
import cl.pinolabs.kevinstore.model.persistence.crud.RolCrud;
import cl.pinolabs.kevinstore.model.persistence.mapper.RolMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RolRepository implements cl.pinolabs.kevinstore.model.domain.repository.RolRepository {

    private final RolCrud crud;
    private final RolMapper mapper;

    public RolRepository(RolCrud crud, RolMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<Rol>> findAll() {
        return Optional.of(mapper.toRoles(crud.findAll()));
    }

    @Override
    public Optional<Rol> findById(int rolId) {
        return crud.findById(rolId)
                .map(mapper::toRol);
    }

    @Override
    public Optional<Rol> findByRolName(String rolName) {
        return crud.findByRolName(rolName)
                .map(mapper::toRol);
    }

    @Override
    public Rol save(Rol rol) {
        return mapper.toRol(crud.save(mapper.toRolEntity(rol)));
    }

    @Override
    public void delete(int rolId) {
        crud.deleteById(rolId);
    }
}