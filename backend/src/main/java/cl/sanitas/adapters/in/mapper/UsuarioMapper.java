package cl.sanitas.adapters.in.mapper;

import cl.sanitas.adapters.in.dto.UsuarioRequestDto;
import cl.sanitas.domain.model.Usuario;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UsuarioMapper {

    public UsuarioRequestDto toDto(Usuario model) {
        if (model == null) {
           return null;
        }
        return new UsuarioRequestDto();
    }

    public Usuario toEntity(UsuarioRequestDto dto) {
        if (dto == null) {
            return null;
        }
        return new Usuario();
    }
}
