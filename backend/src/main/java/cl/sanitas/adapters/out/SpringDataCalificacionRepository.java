package cl.sanitas.adapters.out;

import cl.sanitas.domain.model.Calificacion;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringDataCalificacionRepository extends MongoRepository<Calificacion, ObjectId> {
    Calificacion findByIdEspecialista(ObjectId idEspecialista);
}
