package cl.sanitas.application.port;

import cl.sanitas.domain.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> buscarPorId(String id);
    Optional<Usuario> buscarPorEmail(String email);
    List<Usuario> buscarTodos();
    Usuario guardar(Usuario usuario);
}
