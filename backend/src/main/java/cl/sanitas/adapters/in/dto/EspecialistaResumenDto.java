package cl.sanitas.adapters.in.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EspecialistaResumenDto {
    private String idUsuario;
    private String idEspecialista;
    private String nombre;
    private String descripcion;
    private String especialidad;
    private Double puntuacion;
}
