package cl.sanitas.application.port;

import cl.sanitas.domain.model.User;

import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(String id);
    User save(User user);
}
