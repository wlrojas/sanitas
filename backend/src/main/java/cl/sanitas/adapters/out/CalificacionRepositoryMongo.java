package cl.sanitas.adapters.out;

import cl.sanitas.application.port.CalificacionRepository;
import cl.sanitas.domain.model.Calificacion;
import org.springframework.stereotype.Repository;

@Repository
public class CalificacionRepositoryMongo implements CalificacionRepository {

    private final CalificacionRepository calificacionRepository;

    public CalificacionRepositoryMongo(CalificacionRepository calificacionRepository) {
        this.calificacionRepository = calificacionRepository;
    }

    @Override
    public Calificacion findByIdEspecialista(String idEspecialista) {
        return calificacionRepository.findByIdEspecialista(idEspecialista);
    }
}
