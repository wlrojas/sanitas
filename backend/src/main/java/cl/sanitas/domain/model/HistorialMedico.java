package cl.sanitas.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "historial_medico")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class HistorialMedico {
    private String id;
    private String idPaciente;
    private List<Examen> examenes;
    private String resumen;
}
