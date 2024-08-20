package co.com.softlond.model;

import java.time.LocalDate;

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
public class HistorialModel {
    private String id;
    private Integer contador;
    private String ultimaDecripcion;
    private LocalDate fechaUltimaModificacion;
    private UsuarioModel usuarioUltimaModificacion;
}
