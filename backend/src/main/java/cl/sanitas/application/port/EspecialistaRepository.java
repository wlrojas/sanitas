package cl.sanitas.application.port;

import cl.sanitas.domain.model.Especialista;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface EspecialistaRepository {
    Optional<Especialista> buscarPorId(ObjectId idEspecialista);
    List<Especialista> buscarPorEspecialidad(String especialidad);
    List<Especialista> buscarPorNombre(String nombre);
    List<Especialista> buscarTodos();
}
