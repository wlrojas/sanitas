package cl.sanitas.adapters.in;

import cl.sanitas.adapters.in.dto.CitaDto;
import cl.sanitas.application.usecase.CitasUseCase;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/citas")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class CitaController {

    private final CitasUseCase citasUseCase;

    public CitaController(CitasUseCase citasUseCase) {
        this.citasUseCase = citasUseCase;
    }

    @GetMapping("/all/paciente")
    public List<CitaDto> buscarTodoPaciente(
            @RequestParam(name = "id") ObjectId idPaciente) {
        return citasUseCase.buscarPorPaciente(idPaciente);
    }

    @GetMapping("/all/especialista")
    public List<CitaDto> buscarTodoEspecialista(
            @RequestParam(name = "id") ObjectId idEspecialista) {
        return citasUseCase.buscarPorEspecialista(idEspecialista);
    }
}
