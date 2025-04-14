package cl.sanitas.application.port;

import cl.sanitas.domain.model.Cita;
import org.bson.types.ObjectId;

import java.util.List;

public interface CitasRepository {
    List<Cita> buscarCitasPorPaciente(ObjectId idPaciente);
    List<Cita> buscarCitasPorEspecialista(ObjectId idEspecialista);

}
