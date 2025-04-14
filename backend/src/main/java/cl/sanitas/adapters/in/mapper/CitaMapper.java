package cl.sanitas.adapters.in.mapper;

import cl.sanitas.adapters.in.dto.CitaDto;
import cl.sanitas.domain.model.Cita;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CitaMapper {

    public CitaDto toDto(Cita cita) {
        if (cita == null) {
            return null;
        }
        return CitaDto.builder()
                .id(cita.getId().toHexString())
                .idPaciente(cita.getIdPaciente().toHexString())
                .idEspecialista(cita.getIdEspecialista().toHexString())
                .fecha(cita.getFecha())
                .hora(cita.getHora())
                .status(cita.getStatus())
                .build();
    }

    public Cita toEntity(CitaDto citaDto) {
        if (citaDto == null) {
            return null;
        }
        return new Cita();
    }
}
