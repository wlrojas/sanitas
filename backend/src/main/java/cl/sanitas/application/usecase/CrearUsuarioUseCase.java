package cl.sanitas.application.usecase;

import cl.sanitas.adapters.in.dto.UsuarioDto;
import cl.sanitas.adapters.in.mapper.UsuarioMapper;
import cl.sanitas.application.port.UsuarioRepository;
import cl.sanitas.domain.model.Usuario;
import org.bson.types.ObjectId;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CrearUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public CrearUsuarioUseCase(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioDto crearUsuario(UsuarioDto dto) {
        Usuario usuario = UsuarioMapper.toModel(dto);
        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        return UsuarioMapper.toDto(usuarioRepository.guardar(usuario));
    }

    public UsuarioDto actualizarUsuario(UsuarioDto dto, ObjectId id) {
        Usuario usuario = UsuarioMapper.toModel(dto);
        usuario.setId(id);
        return UsuarioMapper.toDto(usuarioRepository.guardar(usuario));
    }
}

