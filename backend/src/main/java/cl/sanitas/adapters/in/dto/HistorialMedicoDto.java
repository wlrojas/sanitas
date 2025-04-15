package cl.sanitas.adapters.in.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.List;

@Builder
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class HistorialMedicoDto {
    private ObjectId id;
    private ObjectId idPaciente;
    private List<ExamenDto> examenes;
    private String resumen;
}
