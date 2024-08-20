package co.com.softlond.model.gateways;

import co.com.softlond.model.CategoriaModel;
import reactor.core.publisher.Mono;

public interface CategoriaGateways {

    Mono<CategoriaModel> saveCategoria(CategoriaModel categoria);
    Mono<CategoriaModel> findById(String id);
    Mono<CategoriaModel> findByName(String nombre); 
    
}
