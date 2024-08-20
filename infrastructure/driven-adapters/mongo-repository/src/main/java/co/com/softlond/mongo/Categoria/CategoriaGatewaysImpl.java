package co.com.softlond.mongo.Categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.softlond.model.CategoriaModel;
import co.com.softlond.model.gateways.CategoriaGateways;
import reactor.core.publisher.Mono;

@Repository
public class CategoriaGatewaysImpl implements CategoriaGateways {

     @Autowired
     private CategoriaRepository categoriaRepository;

    @Override
    public Mono<CategoriaModel> saveCategoria(CategoriaModel categoria) {
        return categoriaRepository.save(CategoriaMapper.toCollections(categoria))
        .map(categoriaCollections-> CategoriaMapper.toModel(categoriaCollections));
    }

    @Override
    public Mono<CategoriaModel> findById(String id) {
       return categoriaRepository.findById(id)
       .map(categoria->CategoriaMapper.toModel(categoria));
    }

    @Override
    public Mono<CategoriaModel> findByName(String nombre) {
        return categoriaRepository.findByNombre(nombre)
       .map(categoria->CategoriaMapper.toModel(categoria));
    }
    
}
