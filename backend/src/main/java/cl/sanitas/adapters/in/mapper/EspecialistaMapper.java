package cl.sanitas.adapters.in.mapper;

import cl.sanitas.adapters.in.dto.DisponibilidadDto;
import cl.sanitas.adapters.in.dto.EspecialistaCreacionDto;
import cl.sanitas.adapters.in.dto.EspecialistaDto;
import cl.sanitas.domain.model.Disponibilidad;
import cl.sanitas.domain.model.Especialista;
import cl.sanitas.domain.model.Usuario;
import lombok.experimental.UtilityClass;

import java.util.List;

@UtilityClass
public class EspecialistaMapper {
    public Especialista toModel(EspecialistaDto especialistaDto, Usuario usuario) {
        if (especialistaDto == null || usuario == null) {
            return null;
        }
        return Especialista.builder()
                .idUsuario(usuario.getId())
                .descripcion(especialistaDto.getDescripcion())
                .especialidad(especialistaDto.getEspecialidad())
                .disponibilidad(toModel(especialistaDto.getDisponibilidad()))
                .build();
    }

    public EspecialistaCreacionDto toDto(Especialista especialista, Usuario usuario) {
        return EspecialistaCreacionDto.builder()
                .datosUsuario(UsuarioMapper.toDto(usuario))
                .datosEspecialista(EspecialistaMapper.toDto(especialista))
                .build();
    }

    public EspecialistaDto toDto(Especialista especialista) {
        if (especialista == null) {
            return null;
        }
        return EspecialistaDto.builder()
                .id(especialista.getId().toHexString())
                .idUsuario(especialista.getIdUsuario().toHexString())
                .descripcion(especialista.getDescripcion())
                .especialidad(especialista.getEspecialidad())
                .disponibilidad(toDto(especialista.getDisponibilidad()))
                .build();
    }

    public Disponibilidad toModel(DisponibilidadDto dto) {
        if (dto == null) {
            return null;
        }
        return Disponibilidad.builder()
                .fecha(dto.getFecha())
                .horas(dto.getHoras())
                .build();
    }

    public List<Disponibilidad> toModel(List<DisponibilidadDto> dtoList) {
        if (dtoList == null) {
            return null;
        }
        return dtoList.stream().map(EspecialistaMapper::toModel).toList();
    }

    public DisponibilidadDto toDto(Disponibilidad model) {
        if (model == null) {
            return null;
        }
        return DisponibilidadDto.builder()
                .fecha(model.getFecha())
                .horas(model.getHoras())
                .build();
    }

    public List<DisponibilidadDto> toDto(List<Disponibilidad> modelList) {
        if (modelList == null) {
            return null;
        }
        return modelList.stream().map(EspecialistaMapper::toDto).toList();
    }
}
