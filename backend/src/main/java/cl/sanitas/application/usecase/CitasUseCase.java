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

    public List<CitaDto> buscarPorPaciente(ObjectId idPaciente, String status) {
        return citasRepository.buscarCitasPorPaciente(idPaciente, status).stream().map(CitaMapper::toDto).toList();
    }

    public List<CitaDto> buscarPorEspecialista(ObjectId idEspecialista, String status) {
        return citasRepository.buscarCitasPorEspecialista(idEspecialista, status).stream().map(CitaMapper::toDto).toList();
    }

    public CitaDto guardarCita(CitaDto citaDto) {
        return CitaMapper.toDto(citasRepository.guardarCita(CitaMapper.toEntity(citaDto)));
    }
}
