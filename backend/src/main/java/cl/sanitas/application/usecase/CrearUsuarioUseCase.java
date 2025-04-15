package cl.sanitas.application.usecase;

import cl.sanitas.application.port.UsuarioRepository;
import cl.sanitas.domain.model.Usuario;

public class CrearUsuarioUseCase {

    private final UsuarioRepository usuarioRepository;

    public CrearUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.guardar(usuario);
    }
}

