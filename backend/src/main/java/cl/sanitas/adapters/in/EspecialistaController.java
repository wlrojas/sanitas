package cl.sanitas.adapters.in;

import cl.sanitas.adapters.in.dto.EspecialistaDto;
import cl.sanitas.application.usecase.BuscarEspecialistaUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/especialistas")
public class EspecialistaController {

    private final BuscarEspecialistaUseCase buscarEspecialista;

    public EspecialistaController(BuscarEspecialistaUseCase buscarEspecialista) {
        this.buscarEspecialista = buscarEspecialista;
    }

    @GetMapping("/all")
    public List<EspecialistaDto> buscarEspecialistas(@RequestParam(required = false, defaultValue = "") String filtro) {
        return buscarEspecialista.buscarTodos(filtro);
    }
}
