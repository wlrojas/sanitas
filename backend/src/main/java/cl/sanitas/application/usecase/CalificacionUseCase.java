package cl.sanitas.application.usecase;

import cl.sanitas.application.port.CalificacionRepository;
import cl.sanitas.domain.model.Calificacion;

public class CalificacionUseCase {

    private final CalificacionRepository calificacionRepository;

    public CalificacionUseCase(CalificacionRepository calificacionRepository) {
        this.calificacionRepository = calificacionRepository;
    }

    public Calificacion buscarPorIdEspecialista(String idEspecialista) {
        return calificacionRepository.findByIdEspecialista(idEspecialista);
    }
}
