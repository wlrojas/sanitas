package cl.sanitas.adapters.out;

import cl.sanitas.application.port.UsuarioRepository;
import cl.sanitas.domain.model.Usuario;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsuarioRepositoryMongo implements UsuarioRepository {
    private final SpringDataUsuarioRepository repository;
    private final MongoTemplate mongoTemplate;
    private final MappingMongoConverter converter;

    public UsuarioRepositoryMongo(SpringDataUsuarioRepository repository, MongoTemplate mongoTemplate, MappingMongoConverter converter) {
        this.repository = repository;
        this.mongoTemplate = mongoTemplate;
        this.converter = converter;
    }

    @Override
    public Optional<Usuario> buscarPorId(ObjectId id) {
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

    @Override
    public List<Usuario> buscarTodosPorNombreYRol(String nombre, String rol) {
        return repository.findAllByNombreContainingIgnoreCaseAndRol(nombre, rol);
    }

    @Override
    public void actualizarParcial(ObjectId id, Usuario usuario) {
        Update update = new Update();
        if (usuario.getNombre() != null) update.set("nombre", usuario.getNombre());
        if (usuario.getEmail() != null) update.set("email", usuario.getEmail());
        if (usuario.getTelefono() != null) update.set("telefono", usuario.getTelefono());

        Query query = Query.query(Criteria.where("_id").is(id));
        mongoTemplate.updateFirst(query, update, Usuario.class);
    }
}
