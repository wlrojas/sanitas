package cl.sanitas.application.port;

import cl.sanitas.domain.model.HistorialMedico;
import org.bson.types.ObjectId;

import java.util.List;

public interface HistorialMedicoRepository {
    List<HistorialMedico> buscarHistorialPorPaciente(ObjectId idPaciente);
}
