package cl.sanitas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "citas")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Cita {
    private String id;
    private String fecha;
    private String hora;
    private String status;
    private String idEspecialista;
    private String idPaciente;
}
