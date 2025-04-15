package cl.sanitas.adapters.in.mapper;

import cl.sanitas.adapters.in.dto.CalificacionDto;
import cl.sanitas.domain.model.Calificacion;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CalificacionMapper {

    public CalificacionDto toDto(Calificacion calificacion) {
        if (calificacion == null) {
            return null;
        }
        return CalificacionDto.builder()
                .idPaciente(calificacion.getIdPaciente())
                .idEspecialista(calificacion.getIdEspecialista())
                .puntuacion(calificacion.getPuntuacion())
                .comentario(calificacion.getComentario())
                .fecha(calificacion.getFecha())
                .id(calificacion.getId())
                .build();
    }

    public Calificacion toEntity(CalificacionDto calificacionDto) {
        if (calificacionDto == null) {
            return null;
        }
        return Calificacion.builder()
                .idPaciente(calificacionDto.getIdPaciente())
                .idEspecialista(calificacionDto.getIdEspecialista())
                .puntuacion(calificacionDto.getPuntuacion())
                .comentario(calificacionDto.getComentario())
                .fecha(calificacionDto.getFecha())
                .build();
    }
}
