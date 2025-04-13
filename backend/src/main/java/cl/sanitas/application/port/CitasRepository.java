package cl.sanitas.application.port;

import cl.sanitas.domain.model.Cita;

import java.util.List;

public interface CitasRepository {
    List<Cita> buscarCitasPorPaciente(String idPaciente);
    List<Cita> buscarCitasPorEspecialista(String idEspecialista);

}
