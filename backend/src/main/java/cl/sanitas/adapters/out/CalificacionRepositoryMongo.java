package cl.sanitas.adapters.out;

import cl.sanitas.application.port.CalificacionRepository;
import cl.sanitas.domain.model.Calificacion;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

@Repository
public class CalificacionRepositoryMongo implements CalificacionRepository {

    private final SpringDataCalificacionRepository repository;

    public CalificacionRepositoryMongo(SpringDataCalificacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public Calificacion findByIdEspecialista(ObjectId idEspecialista) {
        return repository.findByIdEspecialista(idEspecialista);
    }
}
