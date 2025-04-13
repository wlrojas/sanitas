package cl.sanitas.adapters.out;

import cl.sanitas.domain.model.Calificacion;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringDataCalificacionRepository extends MongoRepository<Calificacion, String> {
    Calificacion findByIdEspecialista(String idEspecialista);
}
