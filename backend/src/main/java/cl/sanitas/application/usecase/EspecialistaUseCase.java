package cl.sanitas.application.usecase;

import cl.sanitas.adapters.in.dto.DisponibilidadDto;
import cl.sanitas.adapters.in.dto.EspecialistaCreacionDto;
import cl.sanitas.adapters.in.dto.EspecialistaResumenDto;
import cl.sanitas.adapters.in.dto.UsuarioDto;
import cl.sanitas.adapters.in.mapper.EspecialistaMapper;
import cl.sanitas.adapters.in.mapper.UsuarioMapper;
import cl.sanitas.application.port.CitasRepository;
import cl.sanitas.application.port.CalificacionRepository;
import cl.sanitas.application.port.EspecialistaRepository;
import cl.sanitas.application.port.UsuarioRepository;
import cl.sanitas.domain.model.Cita;
import cl.sanitas.domain.model.Calificacion;
import cl.sanitas.domain.model.Especialista;
import cl.sanitas.domain.model.Usuario;
import org.bson.types.ObjectId;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EspecialistaUseCase {
    public static final String ROL_ESPECIALISTA = "especialista";
    private final EspecialistaRepository especialistaRepository;
    private final UsuarioRepository usuarioRepository;
    private final CalificacionRepository calificacionRepository;
    private final CitasRepository citasRepository;
    private final PasswordEncoder passwordEncoder;

    public EspecialistaUseCase(EspecialistaRepository especialistaRepository, UsuarioRepository usuarioRepository, CitasRepository citasRepository, PasswordEncoder passwordEncoder, CalificacionRepository calificacionRepository) {
        this.especialistaRepository = especialistaRepository;
        this.usuarioRepository = usuarioRepository;
        this.calificacionRepository = calificacionRepository;
        this.citasRepository = citasRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public List<EspecialistaResumenDto> buscarTodos(String filtro) {
        List<ObjectId> listaIdsUsuario = usuarioRepository.buscarTodosPorNombreYRol(filtro, ROL_ESPECIALISTA).stream()
                .map(Usuario::getId)
                .toList();

        List<Especialista> especialistas = especialistaRepository.buscarTodos(filtro, listaIdsUsuario);
        return especialistas.stream().map(especialista -> {
            Usuario usuario = usuarioRepository.buscarPorId(especialista.getIdUsuario()).orElse(null);
            List<Calificacion> calificaciones = calificacionRepository.buscarPorIdEspecialista(especialista.getId());
            return EspecialistaMapper.toDto(usuario, especialista, promedioCalificacion(calificaciones));
        }).toList();
    }

    public EspecialistaCreacionDto crearEspecialista(EspecialistaCreacionDto dto) {

        UsuarioDto datosUsuario = dto.getDatosUsuario();
        datosUsuario.setPassword(passwordEncoder.encode(datosUsuario.getPassword()));
        Usuario usuario = usuarioRepository.guardar(UsuarioMapper.toModel(datosUsuario));
        Especialista especialista = especialistaRepository.guardar(EspecialistaMapper.toModel(dto.getDatosEspecialista(), usuario));

        return EspecialistaMapper.toDto(especialista, usuario);
    }

    private double promedioCalificacion(List<Calificacion> calificaciones) {
        return calificaciones.stream()
                .mapToInt(Calificacion::getPuntuacion)
                .average()
                .orElse(0.0);
    }

    public List<DisponibilidadDto> disponibilidadEspecialista(ObjectId idEspecialista) {
        List<Cita> citasNoDisponibles = citasRepository
                .buscarCitasPorEspecialista(idEspecialista, "procesando");

        Optional<Especialista> especialista = especialistaRepository
                .buscarPorId(idEspecialista);

        return especialista.map(value -> value.getDisponibilidad().stream()
                .map(disponibilidad -> {
                    List<String> horasDisponibles = new ArrayList<>(disponibilidad.getHoras());
                    citasNoDisponibles.stream()
                            .filter(cita -> cita.getFecha().equals(disponibilidad.getFecha()))
                            .map(Cita::getHora)
                            .forEach(horasDisponibles::remove);

                    return new DisponibilidadDto(disponibilidad.getFecha(), horasDisponibles);
                })
                .filter(dto -> !dto.getHoras().isEmpty())
                .toList()).orElseGet(ArrayList::new);
    }
}
