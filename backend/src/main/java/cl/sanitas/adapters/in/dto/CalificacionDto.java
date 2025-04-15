package cl.sanitas.adapters.in.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CalificacionDto {
    private ObjectId id;
    private ObjectId idPaciente;
    private ObjectId idEspecialista;
    private int puntuacion;
    private String comentario;
    private String fecha;
}
