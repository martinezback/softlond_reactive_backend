package co.com.softlond.model;

import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class PlantillaModel {
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
