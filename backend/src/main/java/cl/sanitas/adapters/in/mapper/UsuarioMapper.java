package cl.sanitas.adapters.in.mapper;

import cl.sanitas.adapters.in.dto.UsuarioDto;
import cl.sanitas.domain.model.Usuario;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UsuarioMapper {

    public UsuarioDto toDto(Usuario model) {
        if (model == null) {
           return null;
        }
        return UsuarioDto.builder()
                .id(model.getId().toHexString())
                .nombre(model.getNombre())
                .email(model.getEmail())
                .password(model.getPassword())
                .telefono(model.getTelefono())
                .rol(model.getRol())
                .build();
    }

    public Usuario toModel(UsuarioDto dto) {
        if (dto == null) {
            return null;
        }
        return Usuario.builder()
                .nombre(dto.getNombre())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .telefono(dto.getTelefono())
                .rol(dto.getRol())
                .build();
    }
}
