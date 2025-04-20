package cl.sanitas.application.usecase;

import cl.sanitas.adapters.in.dto.CitaDto;
import cl.sanitas.adapters.in.mapper.CitaMapper;
import cl.sanitas.application.port.CitasRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CitasUseCase {
    private final CitasRepository citasRepository;

    public CitasUseCase(CitasRepository citasRepository) {
        this.citasRepository = citasRepository;
    }

    public List<CitaDto> buscarPorPaciente(ObjectId idPaciente) {
        return citasRepository.buscarCitasPorPaciente(idPaciente).stream().map(CitaMapper::toDto).toList();
    }

    public List<CitaDto> buscarPorEspecialista(ObjectId idEspecialista) {
        return citasRepository.buscarCitasPorEspecialista(idEspecialista).stream().map(CitaMapper::toDto).toList();
    }
}
