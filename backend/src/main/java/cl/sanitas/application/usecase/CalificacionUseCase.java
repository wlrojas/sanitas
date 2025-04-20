package cl.sanitas.application.usecase;

import cl.sanitas.adapters.in.dto.CalificacionDto;
import cl.sanitas.adapters.in.mapper.CalificacionMapper;
import cl.sanitas.application.port.CalificacionRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

@Service
public class CalificacionUseCase {

    private final CalificacionRepository calificacionRepository;

    public CalificacionUseCase(CalificacionRepository calificacionRepository) {
        this.calificacionRepository = calificacionRepository;
    }

    public CalificacionDto buscarPorIdEspecialista(ObjectId idEspecialista) {
        return CalificacionMapper.toDto(calificacionRepository.buscarPorIdEspecialista(idEspecialista));
    }

    public CalificacionDto guardarCalificacion(CalificacionDto calificacionDto) {
        return CalificacionMapper.toDto(calificacionRepository.guardarCalificacion(CalificacionMapper.toEntity(calificacionDto)));
    }
}
