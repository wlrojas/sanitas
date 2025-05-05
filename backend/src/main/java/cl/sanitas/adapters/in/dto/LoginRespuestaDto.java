package cl.sanitas.adapters.in.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginRespuestaDto {
    private String token;
    //private UsuarioDto usuario;
}
