package cl.sanitas.application.usecase;

import cl.sanitas.adapters.in.dto.CalificacionDto;
import cl.sanitas.adapters.in.mapper.CalificacionMapper;
import cl.sanitas.application.port.CalificacionRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalificacionUseCase {

    private final CalificacionRepository calificacionRepository;

    public CalificacionUseCase(CalificacionRepository calificacionRepository) {
        this.calificacionRepository = calificacionRepository;
    }

    public List<CalificacionDto> buscarPorIdEspecialista(ObjectId idEspecialista) {
        return calificacionRepository.buscarPorIdEspecialista(idEspecialista).stream()
                .map(CalificacionMapper::toDto).toList();
    }

    public CalificacionDto guardarCalificacion(CalificacionDto calificacionDto) {
        return CalificacionMapper.toDto(calificacionRepository.guardarCalificacion(CalificacionMapper.toEntity(calificacionDto)));
    }
}
