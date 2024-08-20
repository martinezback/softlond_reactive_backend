package co.com.softlond.usecase.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.softlond.model.CategoriaModel;
import co.com.softlond.model.gateways.CategoriaGateways;
import reactor.core.publisher.Mono;

@Service
public class CategoriaUseCase {
    @Autowired
    private CategoriaGateways categoriaGateways;

    public Mono<CategoriaModel> saveCategoria(CategoriaModel categoria){
        return categoriaGateways.saveCategoria(categoria);
    }

    public Mono<CategoriaModel> findById(String id){
        return categoriaGateways.findById(id)
        .switchIfEmpty(Mono.empty());
    }

    public Mono<CategoriaModel> findByName(String nombre){
        return categoriaGateways.findByName(nombre)
        .switchIfEmpty(Mono.empty());
    }
    
}
