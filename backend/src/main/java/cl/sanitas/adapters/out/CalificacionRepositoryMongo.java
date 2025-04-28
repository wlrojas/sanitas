package cl.sanitas.adapters.out;

import cl.sanitas.application.port.CalificacionRepository;
import cl.sanitas.domain.model.Calificacion;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CalificacionRepositoryMongo implements CalificacionRepository {

    private final SpringDataCalificacionRepository repository;

    public CalificacionRepositoryMongo(SpringDataCalificacionRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Calificacion> buscarPorIdEspecialista(ObjectId idEspecialista) {
        return repository.findByIdEspecialista(idEspecialista);
    }

    @Override
    public Calificacion guardarCalificacion(Calificacion calificacion) {
        return repository.save(calificacion);
    }
}
