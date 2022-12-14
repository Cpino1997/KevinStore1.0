package cl.pinolabs.kevinstore.model.domain.repository;

import cl.pinolabs.kevinstore.model.domain.dto.User;

import java.util.List;
import java.util.Optional;
public interface UserRepository {
    Optional<List<User>> findAll();
    Optional<User> findByUsername(String username);
    User save(User user);
    void delete(String username);
    boolean existsByUsername(String username);
}