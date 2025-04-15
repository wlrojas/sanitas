package cl.sanitas.application.usecase;

import cl.sanitas.application.port.EspecialistaRepository;
import cl.sanitas.domain.model.Especialista;

import java.util.List;

public class BuscarEspecialistaUseCase {
    private final EspecialistaRepository especialistaRepository;

    public BuscarEspecialistaUseCase(EspecialistaRepository especialistaRepository) {
        this.especialistaRepository = especialistaRepository;
    }

    public List<Especialista> buscarEspecialistasPorNombre(String nombre) {
        return especialistaRepository.buscarPorNombre(nombre);
    }

    public List<Especialista> buscarTodos() {
        return especialistaRepository.buscarTodos();
    }
}
