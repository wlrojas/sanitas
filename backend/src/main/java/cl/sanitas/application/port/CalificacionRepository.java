package cl.sanitas.application.port;

import cl.sanitas.domain.model.Calificacion;
import org.bson.types.ObjectId;

public interface CalificacionRepository {
    Calificacion buscarPorIdEspecialista(ObjectId idEspecialista);
    Calificacion guardarCalificacion(Calificacion calificacion);
}
