package cl.sanitas.adapters.out;

import cl.sanitas.application.port.UsuarioRepository;
import cl.sanitas.domain.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryMongo implements UsuarioRepository {
    private final SpringDataUsuarioRepository repository;

    @Autowired
    public UsuarioRepositoryMongo(SpringDataUsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Usuario> buscarPorId(String id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Usuario> buscarPorEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public List<Usuario> buscarTodos() {
        return repository.findAll();
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return repository.save(usuario);
    }
}
