package cl.sanitas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "calificacion")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Calificacion {
    private String id;
    private String idPaciente;
    private String idEspecialista;
    private int puntuacion;
    private String comentario;
    private String fecha;
}
