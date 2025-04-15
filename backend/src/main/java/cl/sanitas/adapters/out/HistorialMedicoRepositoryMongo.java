package cl.sanitas.adapters.out;

import cl.sanitas.application.port.HistorialMedicoRepository;
import cl.sanitas.domain.model.HistorialMedico;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

@Repository
public class HistorialMedicoRepositoryMongo implements HistorialMedicoRepository {

    private final SpringDataHistorialMedicoRepository historialMedicoRepository;

    public HistorialMedicoRepositoryMongo(SpringDataHistorialMedicoRepository historialMedicoRepository) {
        this.historialMedicoRepository = historialMedicoRepository;
    }

    @Override
    public HistorialMedico buscarHistorialPorPaciente(ObjectId idPaciente) {
        return historialMedicoRepository.findByIdPaciente(idPaciente);
    }

    @Override
    public HistorialMedico guardarHistorialMedico(HistorialMedico historialMedico) {
        return historialMedicoRepository.save(historialMedico);
    }
}
