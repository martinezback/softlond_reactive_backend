package co.com.softlond.mongo.Collections;

import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import co.com.softlond.model.UsuarioModel;
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

@Document(collection = "historial")
public class HistorialCollections {
    @Id
    private String id;
    private Integer contador;
    private String ultimaDecripcion;
    private LocalDate fechaUltimaModificacion;
    private UsuarioModel usuarioUltimaModificacion;
}
