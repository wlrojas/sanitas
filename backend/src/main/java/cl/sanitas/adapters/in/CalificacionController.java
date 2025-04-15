package cl.sanitas.adapters.in;

import cl.sanitas.adapters.in.dto.CalificacionDto;
import cl.sanitas.application.usecase.CalificacionUseCase;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/calificacion")
public class CalificacionController {

    private final CalificacionUseCase calificacionUseCase;

    public CalificacionController(CalificacionUseCase calificacionUseCase) {
        this.calificacionUseCase = calificacionUseCase;
    }

    @GetMapping("/especialista")
    public CalificacionDto buscarCalificacionPorIdEspecialista(@RequestParam(name = "id") ObjectId idEspecialista) {
        return calificacionUseCase.buscarPorIdEspecialista(idEspecialista);
    }

    @PostMapping("/save")
    public CalificacionDto guardarCalificacion(@RequestBody CalificacionDto calificacionDto) {
        return calificacionUseCase.guardarCalificacion(calificacionDto);
    }

}
