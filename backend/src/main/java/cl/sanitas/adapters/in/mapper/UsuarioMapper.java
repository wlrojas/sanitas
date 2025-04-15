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
        return new UsuarioDto();
    }

    public Usuario toModel(UsuarioDto dto) {
        if (dto == null) {
            return null;
        }
        return new Usuario();
    }
}
