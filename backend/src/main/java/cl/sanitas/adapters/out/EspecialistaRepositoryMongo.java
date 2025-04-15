package cl.sanitas.adapters.out;

import cl.sanitas.application.port.EspecialistaRepository;
import cl.sanitas.domain.model.Especialista;
import cl.sanitas.domain.model.Usuario;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EspecialistaRepositoryMongo implements EspecialistaRepository {

    public static final String ROL_ESPECIALISTA = "especialista";
    private final SpringDataEspecialistaRepository especialistaRepository;
    private final SpringDataUsuarioRepository usuarioRepository;

    public EspecialistaRepositoryMongo(SpringDataEspecialistaRepository especialistaRepository, SpringDataUsuarioRepository usuarioRepository) {
        this.especialistaRepository = especialistaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Optional<Especialista> buscarPorId(ObjectId idEspecialista) {
        return especialistaRepository.findByIdUsuario(idEspecialista);
    }

    @Override
    public List<Especialista> buscarPorEspecialidad(String especialidad) {
        return especialistaRepository.findAllByEspecialidad(especialidad);
    }

    @Override
    public List<Especialista> buscarPorNombre(String nombre) {
        List<ObjectId> listaIdsUsuario = usuarioRepository.findAllByNombreContainingIgnoreCaseAndRol(nombre, ROL_ESPECIALISTA)
                .stream().map(Usuario::getId)
                .toList();
        return especialistaRepository.findAllByIdUsuarioIn(listaIdsUsuario);
    }

    @Override
    public List<Especialista> buscarTodos() {
        return especialistaRepository.findAll();
    }
}
