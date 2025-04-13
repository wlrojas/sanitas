package cl.sanitas.application.port;

import cl.sanitas.domain.model.Calificacion;

public interface CalificacionRepository {
    Calificacion findByIdEspecialista(String idEspecialista);
}
