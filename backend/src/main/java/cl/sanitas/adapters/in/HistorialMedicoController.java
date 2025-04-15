package cl.sanitas.adapters.in;

import cl.sanitas.adapters.in.dto.HistorialMedicoDto;
import cl.sanitas.application.usecase.HistorialMedicoUseCase;
import org.bson.types.ObjectId;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/historial")
public class HistorialMedicoController {

    private final HistorialMedicoUseCase historialMedicoUseCase;

    public HistorialMedicoController(HistorialMedicoUseCase historialMedicoUseCase) {
        this.historialMedicoUseCase = historialMedicoUseCase;
    }

    @GetMapping("/all")
    public HistorialMedicoDto getHistorialMedico(@RequestParam(name = "id") ObjectId idPaciente) {
        return historialMedicoUseCase.buscarPorIdPaciente(idPaciente);
    }

    @PostMapping("/save")
    public HistorialMedicoDto guardiarHistorialMedico(@RequestBody HistorialMedicoDto historialMedicoDto) {
        return historialMedicoUseCase.guardarHistorialMedico(historialMedicoDto);
    }
}
