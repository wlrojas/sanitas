package cl.sanitas.application.usecase;

import cl.sanitas.adapters.in.dto.EspecialistaCreacionDto;
import cl.sanitas.adapters.in.dto.EspecialistaResumenDto;
import cl.sanitas.adapters.in.mapper.EspecialistaMapper;
import cl.sanitas.adapters.in.mapper.UsuarioMapper;
import cl.sanitas.application.port.CalificacionRepository;
import cl.sanitas.application.port.EspecialistaRepository;
import cl.sanitas.application.port.UsuarioRepository;
import cl.sanitas.domain.model.Calificacion;
import cl.sanitas.domain.model.Especialista;
import cl.sanitas.domain.model.Usuario;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EspecialistaUseCase {
    public static final String ROL_ESPECIALISTA = "especialista";
    private final EspecialistaRepository especialistaRepository;
    private final UsuarioRepository usuarioRepository;
    private final CalificacionRepository calificacionRepository;


    public EspecialistaUseCase(EspecialistaRepository especialistaRepository, UsuarioRepository usuarioRepository, CalificacionRepository calificacionRepository) {
        this.especialistaRepository = especialistaRepository;
        this.usuarioRepository = usuarioRepository;
        this.calificacionRepository = calificacionRepository;
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

        Usuario usuario = usuarioRepository.guardar(UsuarioMapper.toModel(dto.getDatosUsuario()));
        Especialista especialista = especialistaRepository.guardar(EspecialistaMapper.toModel(dto.getDatosEspecialista(), usuario));

        return EspecialistaMapper.toDto(especialista, usuario);
    }

    private double promedioCalificacion(List<Calificacion> calificaciones) {
        return calificaciones.stream()
                .mapToInt(Calificacion::getPuntuacion)
                .average()
                .orElse(0.0);
    }
}
