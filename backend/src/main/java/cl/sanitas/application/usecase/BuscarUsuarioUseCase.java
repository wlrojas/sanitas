package cl.sanitas.application.usecase;

import cl.sanitas.adapters.in.dto.UsuarioDto;
import cl.sanitas.adapters.in.mapper.UsuarioMapper;
import cl.sanitas.application.port.UsuarioRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public BuscarUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDto> findAll() {
        return usuarioRepository.buscarTodos().stream().map(UsuarioMapper::toDto).toList();
    }

    public UsuarioDto findById(ObjectId id) {
        UsuarioDto dto = UsuarioMapper.toDto(usuarioRepository.buscarPorId(id).orElse(null));
        if (dto != null) {
            dto.setPassword(null);
        }
        return dto;
    }
}
