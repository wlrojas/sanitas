package cl.sanitas.application.usecase;

import cl.sanitas.application.port.UsuarioRepository;
import cl.sanitas.domain.model.Usuario;

import java.util.List;
import java.util.Optional;

public class BuscarUsuarioUseCase {
    private final UsuarioRepository usuarioRepository;

    public BuscarUsuarioUseCase(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public List<Usuario> findAll() {
        return usuarioRepository.buscarTodos();
    }

    public Optional<Usuario> findById(String id) {
        return usuarioRepository.buscarPorId(id);
    }
}
