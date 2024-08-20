package co.com.softlond.mongo.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.softlond.model.UsuarioModel;
import co.com.softlond.model.gateways.UsuarioGateways;
import reactor.core.publisher.Mono;

@Repository
public class UsuarioGatewaysimpl implements UsuarioGateways{

    @Autowired
    private ReactiveUsuarioMongoRepository usuarioMongoRepository;

    @Override
    public Mono<UsuarioModel> saveUsuario(UsuarioModel usuarioModel) {
        return usuarioMongoRepository.save(UsuarioMapper.toCollection(usuarioModel))
                .map(usuarioEntity -> UsuarioMapper.toModel(usuarioEntity));
    }

    @Override
    public Mono<UsuarioModel> findById(String id) {
        return usuarioMongoRepository.findById(id)
        .map(usuario-> UsuarioMapper.toModel(usuario))
        .switchIfEmpty(Mono.empty());
    }

    @Override
    public Mono<UsuarioModel> findByUsername(String username) {
        return usuarioMongoRepository.findByUsername(username)
        .map(usuario->UsuarioMapper.toModel(usuario))
        .switchIfEmpty(Mono.empty());
    }

    
}
