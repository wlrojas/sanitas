package cl.sanitas.adapters.in.mapper;

import cl.sanitas.adapters.in.dto.EspecialistaDto;
import cl.sanitas.domain.model.Especialista;
import cl.sanitas.domain.model.Usuario;
import lombok.experimental.UtilityClass;

@UtilityClass
public class EspecialistaMapper {
    public Especialista toModel(EspecialistaDto dto) {
        if (dto == null) {
            return null;
        }
        return new Especialista();
    }

    public EspecialistaDto toDto(Especialista especialista, Usuario usuario) {
        if (especialista == null || usuario == null) {
            return null;
        }
        return new EspecialistaDto();
    }
}
