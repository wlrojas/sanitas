package cl.sanitas.application.port;

import cl.sanitas.domain.model.Cita;
import org.bson.types.ObjectId;

import java.util.List;

public interface CitasRepository {
    List<Cita> buscarCitasPorPaciente(ObjectId idPaciente, String status);
    List<Cita> buscarCitasPorEspecialista(ObjectId idEspecialista, String status);
    Cita guardarCita(Cita cita);
}
