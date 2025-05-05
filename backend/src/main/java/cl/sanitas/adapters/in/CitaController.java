package cl.sanitas.adapters.in;

import cl.sanitas.adapters.in.dto.CitaDto;
import cl.sanitas.application.usecase.CitasUseCase;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
            @RequestParam(name = "id") ObjectId idPaciente,
            @RequestParam(required = false) String status) {
        return citasUseCase.buscarPorPaciente(idPaciente, status);
    }

    @GetMapping("/all/especialista")
    public List<CitaDto> buscarTodoEspecialista(
            @RequestParam(name = "id") ObjectId idEspecialista,
            @RequestParam(required = false) String status) {
        return citasUseCase.buscarPorEspecialista(idEspecialista, status);
    }

    @PostMapping("/save")
    public CitaDto guardarCita(@RequestBody CitaDto citaDto) {
        return citasUseCase.guardarCita(citaDto);
    }
}
