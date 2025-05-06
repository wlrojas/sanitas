package cl.sanitas.adapters.in;

import cl.sanitas.adapters.in.dto.DisponibilidadDto;
import cl.sanitas.adapters.in.dto.EspecialistaCreacionDto;
import cl.sanitas.adapters.in.dto.EspecialistaResumenDto;
import cl.sanitas.application.usecase.EspecialistaUseCase;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/especialistas")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class EspecialistaController {

    private final EspecialistaUseCase buscarEspecialista;

    public EspecialistaController(EspecialistaUseCase buscarEspecialista) {
        this.buscarEspecialista = buscarEspecialista;
    }

    @GetMapping("/all")
    public List<EspecialistaResumenDto> buscarEspecialistas(@RequestParam(required = false, defaultValue = "") String filtro) {
        return buscarEspecialista.buscarTodos(filtro);
    }

    @PostMapping("/save")
    public EspecialistaCreacionDto guardar(@RequestBody EspecialistaCreacionDto dto) {
        return buscarEspecialista.crearEspecialista(dto);
    }

    @GetMapping("/{idEspecialista}/disponibilidad")
    public List<DisponibilidadDto> obtenerDisponibilidad(@PathVariable("idEspecialista") ObjectId idEspecialista) {
        return buscarEspecialista.disponibilidadEspecialista(idEspecialista);
    }
}
