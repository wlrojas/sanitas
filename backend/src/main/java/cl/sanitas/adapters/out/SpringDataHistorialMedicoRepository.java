package cl.sanitas.adapters.out;

import cl.sanitas.domain.model.HistorialMedico;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SpringDataHistorialMedicoRepository extends MongoRepository<HistorialMedico, ObjectId> {
    HistorialMedico findByIdPaciente(ObjectId idPaciente);
}
