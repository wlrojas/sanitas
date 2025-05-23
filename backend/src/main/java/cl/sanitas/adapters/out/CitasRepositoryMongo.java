package cl.sanitas.adapters.out;

import cl.sanitas.application.port.CitasRepository;
import cl.sanitas.domain.model.Cita;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CitasRepositoryMongo implements CitasRepository {

    private final SpringDataCitasRepository repository;

    public CitasRepositoryMongo(SpringDataCitasRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Cita> buscarCitasPorPaciente(ObjectId idPaciente, String status) {
        return repository.findAllByIdPacienteAndStatusContainingIgnoreCase(idPaciente, status);
    }

    @Override
    public List<Cita> buscarCitasPorEspecialista(ObjectId idEspecialista, String status) {
        return repository.findAllByIdEspecialistaAndStatusContainingIgnoreCase(idEspecialista, status);
    }

    @Override
    public Cita guardarCita(Cita cita) {
        return repository.save(cita);
    }
}
