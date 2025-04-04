package cl.sanitas.adapters.out;

import cl.sanitas.application.port.UserRepository;
import cl.sanitas.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryMongo implements UserRepository {
    private final SpringDataUserRepository repository;

    @Autowired
    public UserRepositoryMongo(SpringDataUserRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<User> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }
}
