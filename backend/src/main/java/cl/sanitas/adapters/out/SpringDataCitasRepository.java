package cl.sanitas.adapters.out;

import cl.sanitas.domain.model.Cita;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SpringDataCitasRepository extends MongoRepository<Cita, ObjectId> {
    List<Cita> findAllByIdEspecialista(ObjectId idEspecialista);
    List<Cita> findAllByIdPaciente(ObjectId idPaciente);
}
