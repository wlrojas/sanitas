package cl.sanitas.configuration;

import cl.sanitas.application.port.CalificacionRepository;
import cl.sanitas.application.port.CitasRepository;
import cl.sanitas.application.port.EspecialistaRepository;
import cl.sanitas.application.port.HistorialMedicoRepository;
import cl.sanitas.application.port.UsuarioRepository;
import cl.sanitas.application.usecase.BuscarEspecialistaUseCase;
import cl.sanitas.application.usecase.BuscarUsuarioUseCase;
import cl.sanitas.application.usecase.CalificacionUseCase;
import cl.sanitas.application.usecase.CitasUseCase;
import cl.sanitas.application.usecase.CrearUsuarioUseCase;
import cl.sanitas.application.usecase.HistorialMedicoUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public CrearUsuarioUseCase crearUsuarioUseCase(UsuarioRepository usuarioRepository) {
        return new CrearUsuarioUseCase(usuarioRepository);
    }

    @Bean
    public BuscarUsuarioUseCase buscarUsuarioUseCase(UsuarioRepository usuarioRepository) {
        return new BuscarUsuarioUseCase(usuarioRepository);
    }

    @Bean
    public CalificacionUseCase calificacionUseCase(CalificacionRepository calificacionRepository) {
        return new CalificacionUseCase(calificacionRepository);
    }

    @Bean
    public BuscarEspecialistaUseCase buscarEspecialistaUseCase(EspecialistaRepository especialistaRepository) {
        return new BuscarEspecialistaUseCase(especialistaRepository);
    }

    @Bean
    public CitasUseCase citasUseCase(CitasRepository citasRepository) {
        return new CitasUseCase(citasRepository);
    }

    @Bean
    public HistorialMedicoUseCase historialMedicoUseCase(HistorialMedicoRepository historialRepository) {
        return new HistorialMedicoUseCase(historialRepository);
    }
}
