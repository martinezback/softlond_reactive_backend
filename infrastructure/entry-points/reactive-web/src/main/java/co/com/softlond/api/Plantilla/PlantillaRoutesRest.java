package co.com.softlond.api.Plantilla;
import org.springframework.context.annotation.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class PlantillaRoutesRest {
    @Bean
    public RouterFunction<ServerResponse> plantillaRoutes(PlantillaHandler plantillaHandler) {
        return route(POST("/api/plantilla/save"), plantillaHandler::savePlantilla)
        .andRoute(PUT("/api/plantilla/update"), plantillaHandler::udpatePlantilla);
    }
}
