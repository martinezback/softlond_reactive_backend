package co.com.softlond.mongo.Usuario;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import co.com.softlond.mongo.Collections.UsuarioCollections;
import reactor.core.publisher.Mono;

public interface ReactiveUsuarioMongoRepository extends ReactiveMongoRepository<UsuarioCollections,String>{
    
    public Mono<UsuarioCollections> findByUsername(String username);
}
