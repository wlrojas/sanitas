package cl.sanitas.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection = "historial_medico")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HistorialMedico {
    @MongoId
    private ObjectId id;
    private ObjectId idPaciente;
    private List<Examen> examenes;
    private String resumen;
}
