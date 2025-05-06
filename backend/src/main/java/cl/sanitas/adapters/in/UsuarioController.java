package cl.sanitas.adapters.in;

import cl.sanitas.adapters.in.dto.UsuarioDto;
import cl.sanitas.application.usecase.BuscarUsuarioUseCase;
import cl.sanitas.application.usecase.CrearUsuarioUseCase;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

    @GetMapping("/{id}")
    public UsuarioDto buscarUsuarioPorId(@PathVariable ObjectId id) {
        return buscarUsuarioUseCase.findById(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizarUsuario(@PathVariable ObjectId id, @RequestBody UsuarioDto usuario) {
        try {
            crearUsuarioUseCase.actualizarUsuario(usuario, id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
}
