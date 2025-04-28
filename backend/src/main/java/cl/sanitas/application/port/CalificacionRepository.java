package cl.sanitas.application.port;

import cl.sanitas.domain.model.Calificacion;
import org.bson.types.ObjectId;

import java.util.List;

public interface CalificacionRepository {
    List<Calificacion> buscarPorIdEspecialista(ObjectId idEspecialista);
    Calificacion guardarCalificacion(Calificacion calificacion);
}
