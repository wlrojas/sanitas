package cl.sanitas.configuration;

import cl.sanitas.application.port.UserRepository;
import cl.sanitas.application.usecase.CrearUsuarioUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CrearUsuarioUseCase crearUsuarioUseCase(UserRepository userRepository) {
        return new CrearUsuarioUseCase(userRepository);
    }
}
