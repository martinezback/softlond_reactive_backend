package co.com.softlond.api.Usuario;

import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class UsuarioRoutesRest {
    public class PlantillaRoutesRest {
    
    @Bean
    public RouterFunction<ServerResponse> usuarioRoutes(UsuarioHandler usuarioHandler) {
        return route(POST("/api/usuario/save"), usuarioHandler::saveUsuario);
    }
    
    }

}
