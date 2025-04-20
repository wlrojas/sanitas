package cl.sanitas.application.usecase;

import cl.sanitas.adapters.in.dto.EspecialistaCreacionDto;
import cl.sanitas.adapters.in.dto.EspecialistaDto;
import cl.sanitas.adapters.in.mapper.EspecialistaMapper;
import cl.sanitas.adapters.in.mapper.UsuarioMapper;
import cl.sanitas.application.port.EspecialistaRepository;
import cl.sanitas.application.port.UsuarioRepository;
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


    public EspecialistaUseCase(EspecialistaRepository especialistaRepository, UsuarioRepository usuarioRepository) {
        this.especialistaRepository = especialistaRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<EspecialistaDto> buscarTodos(String filtro) {
        List<ObjectId> listaIdsUsuario = usuarioRepository.buscarTodosPorNombreYRol(filtro, ROL_ESPECIALISTA).stream()
                .map(Usuario::getId)
                .toList();
        return especialistaRepository.buscarTodos(filtro, listaIdsUsuario).stream()
                .map(EspecialistaMapper::toDto).toList();
    }

    public EspecialistaCreacionDto crearEspecialista(EspecialistaCreacionDto dto) {

        Usuario usuario = usuarioRepository.guardar(UsuarioMapper.toModel(dto.getDatosUsuario()));
        Especialista especialista = especialistaRepository.guardar(EspecialistaMapper.toModel(dto.getDatosEspecialista(), usuario));

        return EspecialistaMapper.toDto(especialista, usuario);
    }
}
