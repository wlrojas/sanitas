package cl.sanitas.adapters.in.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CitaDto {

    private String id;
    private String fecha;
    private String hora;
    private String status;
    private String idEspecialista;
    private String idPaciente;
}
