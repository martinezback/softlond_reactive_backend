package co.com.softlond.model.gateways;

import co.com.softlond.model.UsuarioModel;
import reactor.core.publisher.Mono;

public interface UsuarioGateways {
    
    public Mono<UsuarioModel> saveUsuario (UsuarioModel usuarioModel);
    public Mono<UsuarioModel> findById (String  id);
    public Mono<UsuarioModel> findByUsername (String  username);
    
}
