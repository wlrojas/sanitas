package cl.sanitas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection = "especialistas")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Especialista {
    @MongoId
    private ObjectId id;
    private ObjectId idUsuario;
    private String descripcion;
    private String especialidad;
    private List<Disponibilidad> disponibilidad;
}
