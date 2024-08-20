package co.com.softlond.api.Plantilla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.softlond.api.ResponseHandler.CustomResponse;
import co.com.softlond.model.PlantillaModel;
import co.com.softlond.usecase.Plantilla.PlantillaUseCase;
import reactor.core.publisher.Mono;

@Service
public class PlantillaHandler {

    @Autowired
    private PlantillaUseCase plantillaUseCase;

    public Mono<ServerResponse> savePlantilla(ServerRequest request) {
        return request.bodyToMono(PlantillaModel.class)
                .flatMap(plantillaUseCase::savePlantilla)
                .flatMap(plantilla -> ServerResponse.ok().bodyValue(CustomResponse.builder().statusCode(HttpStatus.CREATED.value()).message("Plantilla Creada").data(plantilla).build()))
                .switchIfEmpty(ServerResponse.noContent().build())
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }

    public Mono<ServerResponse> udpatePlantilla(ServerRequest request) {
        return request.bodyToMono(PlantillaModel.class)
                .flatMap(plantillaUseCase::updatePlantilla)
                .flatMap(plantilla -> ServerResponse.status(HttpStatus.ACCEPTED).bodyValue(CustomResponse.builder().statusCode(HttpStatus.ACCEPTED.value()).message("Plantilla Actualizada").data(plantilla).build()))
                .switchIfEmpty(ServerResponse.noContent().build())
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        return request.bodyToMono(String.class)
                .flatMap(plantillaUseCase::findById)
                .flatMap(plantilla -> ServerResponse.status(HttpStatus.ACCEPTED).bodyValue(CustomResponse.builder().statusCode(HttpStatus.ACCEPTED.value()).message("Plantilla Actualizada").data(plantilla).build()))
                .switchIfEmpty(ServerResponse.noContent().build())
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }
}
