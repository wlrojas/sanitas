package cl.sanitas.adapters.in;

import cl.sanitas.application.usecase.CrearUsuarioUseCase;
import cl.sanitas.domain.model.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final CrearUsuarioUseCase crearUsuarioUseCase;

    public UserController(CrearUsuarioUseCase crearUsuarioUseCase) {
        this.crearUsuarioUseCase = crearUsuarioUseCase;
    }

    public User crearUsuario(@RequestBody User user) {
        return crearUsuarioUseCase.crearUsuario(user);
    }
}
