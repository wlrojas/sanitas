package cl.sanitas.application.usecase;

import cl.sanitas.adapters.in.dto.HistorialMedicoDto;
import cl.sanitas.adapters.in.mapper.HistorialMedicoMapper;
import cl.sanitas.application.port.HistorialMedicoRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class HistorialMedicoUseCase {

    private final HistorialMedicoRepository historialMedicoRepository;

    public HistorialMedicoUseCase(HistorialMedicoRepository historialMedicoRepository) {
        this.historialMedicoRepository = historialMedicoRepository;
    }

    public HistorialMedicoDto buscarPorIdPaciente(ObjectId objectId) {
        return HistorialMedicoMapper.toDto(historialMedicoRepository.buscarHistorialPorPaciente(objectId));
    }

    public HistorialMedicoDto guardarHistorialMedico(HistorialMedicoDto historialMedicoDto) {
        return HistorialMedicoMapper.toDto(historialMedicoRepository.guardarHistorialMedico(HistorialMedicoMapper.toModel(historialMedicoDto)));
    }
}
