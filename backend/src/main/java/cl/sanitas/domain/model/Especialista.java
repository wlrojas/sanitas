package cl.sanitas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "especialistas")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Especialista {
    private String id;
    private String idUsuario;
    private String descripcion;
    private String especialidad;
    private List<Disponibilidad> disponibilidad;
}
