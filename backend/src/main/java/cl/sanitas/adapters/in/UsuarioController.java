package cl.sanitas.adapters.in;

import cl.sanitas.adapters.in.dto.UsuarioDto;
import cl.sanitas.application.usecase.BuscarUsuarioUseCase;
import cl.sanitas.application.usecase.CrearUsuarioUseCase;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class UsuarioController {

    private final CrearUsuarioUseCase crearUsuarioUseCase;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;

    public UsuarioController(CrearUsuarioUseCase crearUsuarioUseCase, BuscarUsuarioUseCase buscarUsuarioUseCase) {
        this.crearUsuarioUseCase = crearUsuarioUseCase;
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
    }

    @PostMapping("/save")
    public UsuarioDto crearUsuario(@RequestBody UsuarioDto usuario) {
        return crearUsuarioUseCase.crearUsuario(usuario);
    }

    @GetMapping("/all")
    public List<UsuarioDto> listarUsuarios() {
        return buscarUsuarioUseCase.findAll();
    }
}
