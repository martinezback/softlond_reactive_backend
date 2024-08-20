package co.com.softlond.mongo.Categoria;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import co.com.softlond.mongo.Collections.CategoriaCollections;
import reactor.core.publisher.Mono;

public interface CategoriaRepository extends ReactiveMongoRepository<CategoriaCollections,String> {
    public Mono<CategoriaCollections> findByNombre(String nombre);
}
