package cl.sanitas.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private String id;
    private String nombre;
    private String password;
    private String email;
    private String rol;
    public User() {}
}
