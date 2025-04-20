package cl.sanitas.adapters.out;

import cl.sanitas.domain.model.Especialista;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataEspecialistaRepository extends MongoRepository<Especialista, ObjectId> {
    Optional<Especialista> findByIdUsuario(ObjectId idUsuario);
    List<Especialista> findAllByEspecialidadContainingIgnoreCaseOrIdUsuarioIn(String nombre, List<ObjectId> idsUsuario);
    List<Especialista> findAllByEspecialidadContainingIgnoreCase(String especialidad);

}
