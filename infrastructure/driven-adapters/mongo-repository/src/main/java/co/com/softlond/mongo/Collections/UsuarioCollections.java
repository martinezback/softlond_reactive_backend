package co.com.softlond.mongo.Collections;

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

@Document(collection = "usuarios")
public class UsuarioCollections {
    @Id
    private String id;
    private String nombre;
    private String dni;
    private String username;
    private String password;
}
