package cl.sanitas.adapters.in;

import cl.sanitas.adapters.in.dto.LoginDto;
import cl.sanitas.adapters.in.dto.LoginRespuestaDto;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/inicio")
@CrossOrigin(origins = {"http://localhost:5173", "http://localhost:3000"})
public class AuthController {

    private final AuthenticateUseCase authenticateUseCase;

    public AuthController(AuthenticateUseCase authenticateUseCase) {
        this.authenticateUseCase = authenticateUseCase;
    }

    @PostMapping("/login")
    public LoginRespuestaDto login(@RequestBody LoginDto loginDto) {
        String token = authenticateUseCase.authenticate(loginDto.getEmail(), loginDto.getPassword());
        return new LoginRespuestaDto(token);
    }
}
