package cl.sanitas.application.port;

import cl.sanitas.domain.model.Especialista;

import java.util.List;
import java.util.Optional;

public interface EspecialistaRepository {
    Optional<Especialista> buscarPorId(Long id);
    Optional<List<Especialista>> buscarPorEspecialidad(String especialidad);
    Optional<List<Especialista>> buscarPorNombre(String nombre);

}
