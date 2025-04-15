package cl.sanitas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "calificacion")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@Builder
public class Calificacion {
    @MongoId
    private ObjectId id;
    private ObjectId idPaciente;
    private ObjectId idEspecialista;
    private int puntuacion;
    private String comentario;
    private String fecha;
}
