package cl.sanitas.adapters.in;

import cl.sanitas.application.usecase.BuscarUsuarioUseCase;
import cl.sanitas.application.usecase.CrearUsuarioUseCase;
import cl.sanitas.domain.model.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UsuarioController {

    private final CrearUsuarioUseCase crearUsuarioUseCase;
    private final BuscarUsuarioUseCase buscarUsuarioUseCase;

    public UsuarioController(CrearUsuarioUseCase crearUsuarioUseCase, BuscarUsuarioUseCase buscarUsuarioUseCase) {
        this.crearUsuarioUseCase = crearUsuarioUseCase;
        this.buscarUsuarioUseCase = buscarUsuarioUseCase;
    }

    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return crearUsuarioUseCase.crearUsuario(usuario);
    }

    @GetMapping("/all")
    public List<Usuario> listarUsuarios() {
        return buscarUsuarioUseCase.findAll();
    }
}
