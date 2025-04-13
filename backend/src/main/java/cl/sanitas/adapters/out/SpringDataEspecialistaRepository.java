package cl.sanitas.adapters.out;

import cl.sanitas.domain.model.Especialista;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface SpringDataEspecialistaRepository extends MongoRepository<Especialista, String> {
    Optional<Especialista> findByIdUsuario(String nombre);
    List<Especialista> findAllByEspecialidad(String especialidad);

}
