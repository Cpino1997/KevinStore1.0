package cl.pinolabs.kevinstore.model.persistence.repository;

import cl.pinolabs.kevinstore.model.domain.dto.User;
import cl.pinolabs.kevinstore.model.domain.repository.UserRepository;
import cl.pinolabs.kevinstore.model.persistence.crud.UsuarioCrud;
import cl.pinolabs.kevinstore.model.persistence.entity.UserEntity;
import cl.pinolabs.kevinstore.model.persistence.mapper.UserMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository {

    private final UsuarioCrud crud;
    private final UserMapper mapper;

    public UsuarioRepository(UsuarioCrud crud, UserMapper mapper) {
        this.crud = crud;
        this.mapper = mapper;
    }

    @Override
    public Optional<List<User>> findAll() {
        return Optional.of(mapper.toUsers((List<UserEntity>) crud.findAll()));
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return crud.findById(username)
                .map(mapper::toUser);
    }

    @Override
    public User save(User user) {
        return mapper.toUser(crud.save(mapper.toUserEntity(user)));
    }

    @Override
    public void delete(String username) {
        crud.deleteById(username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return crud.existsByUsername(username);
    }
}