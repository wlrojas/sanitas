package cl.sanitas.application.port;

import cl.sanitas.domain.model.Usuario;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository {
    Optional<Usuario> buscarPorId(ObjectId id);
    Optional<Usuario> buscarPorEmail(String email);
    List<Usuario> buscarTodos();
    Usuario guardar(Usuario usuario);
    List<Usuario> buscarTodosPorNombreYRol(String nombre, String rol);
    void actualizarParcial(ObjectId id, Usuario usuario);
}
