package cl.sanitas.application.port;

import cl.sanitas.domain.model.HistorialMedico;

import java.util.List;

public interface HistorialMedicoRepository {
    List<HistorialMedico> buscarHistorialPorPaciente(String idPaciente);
}
