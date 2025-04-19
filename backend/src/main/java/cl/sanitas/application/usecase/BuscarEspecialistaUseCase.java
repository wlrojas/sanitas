package cl.sanitas.application.usecase;

import cl.sanitas.adapters.in.dto.EspecialistaDto;
import cl.sanitas.adapters.in.mapper.EspecialistaMapper;
import cl.sanitas.application.port.EspecialistaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarEspecialistaUseCase {
    private final EspecialistaRepository especialistaRepository;


    public BuscarEspecialistaUseCase(EspecialistaRepository especialistaRepository) {
        this.especialistaRepository = especialistaRepository;
    }

    public List<EspecialistaDto> buscarTodos(String filtro) {
        return especialistaRepository.buscarTodos(filtro).stream()
                .map(EspecialistaMapper::toDto).toList();
    }
}
