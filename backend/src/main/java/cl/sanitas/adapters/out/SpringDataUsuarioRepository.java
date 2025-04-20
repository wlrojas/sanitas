package cl.sanitas.adapters.out;

import cl.sanitas.domain.model.Usuario;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataUsuarioRepository extends MongoRepository<Usuario, ObjectId> {
    Optional<Usuario> findByEmail(String email);
    List<Usuario> findAllByNombreContainingIgnoreCaseAndRol(String nombre, String rol);
}

