package co.com.softlond.mongo.Categoria;

import co.com.softlond.model.CategoriaModel;
import co.com.softlond.mongo.Collections.CategoriaCollections;

public class CategoriaMapper {

    public static CategoriaModel toModel (CategoriaCollections categoriaCollections){
        return CategoriaModel.builder()
        .id(categoriaCollections.getId())
        .nombre(categoriaCollections.getNombre())
        .build();
    }

    public static CategoriaCollections toCollections (CategoriaModel categoriaModel){
        return CategoriaCollections.builder()
        .id(categoriaModel.getId())
        .nombre(categoriaModel.getNombre())
        .build();
    }
}
