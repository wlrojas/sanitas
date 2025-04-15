package cl.sanitas.adapters.in;

import cl.sanitas.application.usecase.BuscarEspecialistaUseCase;
import cl.sanitas.domain.model.Especialista;
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
    public List<Especialista> buscarEspecialistas(@RequestParam(required = false) String nombre) {
        if (nombre == null) {
            return buscarEspecialista.buscarTodos();
        }
        return buscarEspecialista.buscarEspecialistasPorNombre(nombre);
    }
}
