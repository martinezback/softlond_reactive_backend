package co.com.softlond.api.Historial;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class HistorialRoutesRest {

    @Bean
    public RouterFunction<ServerResponse> HistorialRoutes(HistorialHandler historialHandler) {
        return route(POST("/api/historial/save"), historialHandler::saveHistorial)
                .andRoute(GET("/api/historial/ver"), historialHandler::getHistorial);
    }


}
