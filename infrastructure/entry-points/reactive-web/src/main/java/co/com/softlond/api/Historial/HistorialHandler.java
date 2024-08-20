package co.com.softlond.api.Historial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.usecase.Historial.HistorialUseCase;
import reactor.core.publisher.Mono;

@Service
public class HistorialHandler {

    @Autowired
    private HistorialUseCase historialUseCase;

    public Mono<ServerResponse> saveHistorial(ServerRequest request) {
        return request.bodyToMono(HistorialModel.class)
                .flatMap(historialUseCase::saveHistorial)
                .flatMap(historial -> ServerResponse.ok().bodyValue(historial))
                .switchIfEmpty(ServerResponse.noContent().build())
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }

    public Mono<ServerResponse> getHistorial(ServerRequest request) {
        return historialUseCase.getHistorial()
                .flatMap(historial -> ServerResponse.ok().bodyValue(historial))
                .switchIfEmpty(ServerResponse.noContent().build())
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));

    }
}
