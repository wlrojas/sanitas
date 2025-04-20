package cl.sanitas.application.usecase;

import cl.sanitas.adapters.in.dto.UsuarioDto;
import cl.sanitas.adapters.in.mapper.UsuarioMapper;
import cl.sanitas.application.port.UsuarioRepository;
import cl.sanitas.domain.model.Usuario;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BuscarUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public BuscarUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<UsuarioDto> findAll() {
        return usuarioRepository.buscarTodos().stream().map(UsuarioMapper::toDto).toList();
    }

    public Optional<Usuario> findById(ObjectId id) {
        return usuarioRepository.buscarPorId(id);
    }
}
