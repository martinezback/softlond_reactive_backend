package co.com.softlond.usecase.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.softlond.model.UsuarioModel;
import co.com.softlond.model.gateways.UsuarioGateways;
import reactor.core.publisher.Mono;

@Service
public class UsuarioUseCase {
    @Autowired
    private UsuarioGateways usuarioGateways;


    public Mono<UsuarioModel> saveUsuario(UsuarioModel usuario){
        return usuarioGateways.saveUsuario(usuario);
    }

    public Mono<UsuarioModel> findById(String id){
        return usuarioGateways.findById(id)
        .switchIfEmpty(Mono.empty())
        ;
    }

    public Mono<UsuarioModel> findByUsername(String username){
        return usuarioGateways.findByUsername(username);
    }
}
