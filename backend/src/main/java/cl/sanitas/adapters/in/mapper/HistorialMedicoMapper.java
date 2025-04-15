package cl.sanitas.adapters.in.mapper;

import cl.sanitas.adapters.in.dto.ExamenDto;
import cl.sanitas.adapters.in.dto.HistorialMedicoDto;
import cl.sanitas.domain.model.Examen;
import cl.sanitas.domain.model.HistorialMedico;
import lombok.experimental.UtilityClass;

@UtilityClass
public class HistorialMedicoMapper {

    public HistorialMedicoDto toDto(HistorialMedico historialMedico) {
        if (historialMedico == null) {
            return null;
        }
        return HistorialMedicoDto.builder()
                .id(historialMedico.getId())
                .idPaciente(historialMedico.getIdPaciente())
                .resumen(historialMedico.getResumen())
                .examenes(historialMedico.getExamenes().stream().map(HistorialMedicoMapper::toDto).toList())
                .build();
    }

    public ExamenDto toDto(Examen examen) {
        if (examen == null) {
            return null;
        }
        return ExamenDto.builder()
                .fecha(examen.getFecha())
                .nombre(examen.getNombre())
                .resultado(examen.getResultado())
                .build();
    }

    public HistorialMedico toModel(HistorialMedicoDto historialMedicoDto) {
        if (historialMedicoDto == null) {
            return null;
        }
        return HistorialMedico.builder()
                .resumen(historialMedicoDto.getResumen())
                .idPaciente(historialMedicoDto.getIdPaciente())
                .examenes(historialMedicoDto.getExamenes().stream().map(HistorialMedicoMapper::toModel).toList())
                .build();
    }

    public Examen toModel(ExamenDto examenDto) {
        if (examenDto == null) {
            return null;
        }
        return Examen.builder()
                .fecha(examenDto.getFecha())
                .nombre(examenDto.getNombre())
                .resultado(examenDto.getResultado())
                .build();
    }
}
