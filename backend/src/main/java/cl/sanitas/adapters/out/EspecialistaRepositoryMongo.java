package cl.sanitas.adapters.out;

import cl.sanitas.application.port.EspecialistaRepository;
import cl.sanitas.domain.model.Especialista;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class EspecialistaRepositoryMongo implements EspecialistaRepository {

    private final SpringDataEspecialistaRepository especialistaRepository;

    public EspecialistaRepositoryMongo(SpringDataEspecialistaRepository especialistaRepository) {
        this.especialistaRepository = especialistaRepository;
    }

    @Override
    public Optional<Especialista> buscarPorId(ObjectId idEspecialista) {
        return especialistaRepository.findById(idEspecialista);
    }

    @Override
    public List<Especialista> buscarPorEspecialidad(String especialidad) {
        return especialistaRepository.findAllByEspecialidadContainingIgnoreCase(especialidad);
    }

    @Override
    public List<Especialista> buscarTodos(String filtro, List<ObjectId> listaIdsUsuario) {
        return especialistaRepository.findAllByEspecialidadContainingIgnoreCaseOrIdUsuarioIn(filtro, listaIdsUsuario);
    }

    @Override
    public Especialista guardar(Especialista especialista) {
        return especialistaRepository.save(especialista);
    }
}
