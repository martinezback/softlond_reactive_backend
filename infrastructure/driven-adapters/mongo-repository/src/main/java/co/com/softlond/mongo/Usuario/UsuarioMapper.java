package co.com.softlond.mongo.Usuario;

import co.com.softlond.model.UsuarioModel;
import co.com.softlond.mongo.Collections.UsuarioCollections;

public class UsuarioMapper {

    public static UsuarioCollections toCollection (UsuarioModel usuario){
        return UsuarioCollections.builder()
        .id(usuario.getId())
        .nombre(usuario.getNombre())
        .username(usuario.getUsername())
        .dni(usuario.getDni())
        .password(usuario.getPassword())
        .build();
    }

    public static UsuarioModel toModel (UsuarioCollections usuario){
        return UsuarioModel.builder()
        .id(usuario.getId())
        .nombre(usuario.getNombre())
        .username(usuario.getUsername())
        .dni(usuario.getDni())
        .password(usuario.getPassword())
        .build();
    }
    
}
