package cl.sanitas.adapters.out;

import cl.sanitas.domain.model.Calificacion;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SpringDataCalificacionRepository extends MongoRepository<Calificacion, ObjectId> {
    List<Calificacion> findByIdEspecialista(ObjectId idEspecialista);
}
