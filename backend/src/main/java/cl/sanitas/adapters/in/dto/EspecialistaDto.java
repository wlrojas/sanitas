package cl.sanitas.adapters.in.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EspecialistaDto {
    private String id;
    private String idUsuario;
    private String descripcion;
    private String especialidad;
    private List<DisponibilidadDto> disponibilidad;
}
