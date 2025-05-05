package cl.sanitas.adapters.out;

import cl.sanitas.domain.model.Cita;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SpringDataCitasRepository extends MongoRepository<Cita, ObjectId> {
    List<Cita> findAllByIdEspecialistaAndStatus(ObjectId idEspecialista, String status);
    List<Cita> findAllByIdPacienteAndStatus(ObjectId idPaciente, String status);
}
