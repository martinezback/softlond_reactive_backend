package co.com.softlond.mongo.Collections;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "plantillas")
public class PlantillaCollections {

    @Id
    private String id;
    private String autor;
    private String nombre;
    private String version;
    private String categoria;
    private Boolean activo;
    private String descripcion;
    private List<String> etiqueta;
    private LocalDate fechaActualizacion;

    
}
