package cl.sanitas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "citas")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Cita {
    @MongoId
    private ObjectId id;
    private String fecha;
    private String hora;
    private String status;
    private ObjectId idEspecialista;
    private ObjectId idPaciente;
}
