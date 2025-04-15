package cl.sanitas.application.port;

import cl.sanitas.domain.model.HistorialMedico;
import org.bson.types.ObjectId;

public interface HistorialMedicoRepository {
    HistorialMedico buscarHistorialPorPaciente(ObjectId idPaciente);
    HistorialMedico guardarHistorialMedico(HistorialMedico historialMedico);
}
