package co.com.softlond.api.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.com.softlond.api.ResponseHandler.CustomResponse;
import co.com.softlond.model.UsuarioModel;
import co.com.softlond.usecase.Usuario.UsuarioUseCase;
import reactor.core.publisher.Mono;

@Service
public class UsuarioHandler {
    
    @Autowired
    private UsuarioUseCase usuarioUseCase;

    public Mono<ServerResponse> saveUsuario(ServerRequest request) {
        return request.bodyToMono(UsuarioModel.class)
                .flatMap(usuarioUseCase::saveUsuario)
                .flatMap(usuario -> ServerResponse.ok().bodyValue(CustomResponse.builder().statusCode(HttpStatus.CREATED.value()).message("usuario creado").data(usuario).build()))
                .switchIfEmpty(ServerResponse.noContent().build())
                .onErrorResume(error -> ServerResponse.badRequest().bodyValue(error.getMessage()));
    }
}
