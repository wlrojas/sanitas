package cl.sanitas.adapters.out;

import cl.sanitas.domain.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringDataUserRepository extends MongoRepository<User, String> {
}

