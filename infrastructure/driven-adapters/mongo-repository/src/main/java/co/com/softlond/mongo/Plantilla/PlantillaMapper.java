package co.com.softlond.mongo.Plantilla;

import co.com.softlond.model.PlantillaModel;
import co.com.softlond.mongo.Collections.PlantillaCollections;

public class PlantillaMapper {

    public static PlantillaModel toModel (PlantillaCollections plantillaCollections){
        return PlantillaModel.builder()
        .id(plantillaCollections.getId())
        .autor(plantillaCollections.getAutor())
        .nombre(plantillaCollections.getNombre())
        .version(plantillaCollections.getVersion())
        .categoria(plantillaCollections.getCategoria())
        .activo(plantillaCollections.getActivo())
        .descripcion(plantillaCollections.getDescripcion())
        .etiqueta(plantillaCollections.getEtiqueta())
        .fechaActualizacion(plantillaCollections.getFechaActualizacion())
        .build();
    }

    public static PlantillaCollections toCollections (PlantillaModel plantillaModel){
        return PlantillaCollections.builder()
        .id(plantillaModel.getId())
        .autor(plantillaModel.getAutor())
        .nombre(plantillaModel.getNombre())
        .version(plantillaModel.getVersion())
        .categoria(plantillaModel.getCategoria())
        .activo(plantillaModel.getActivo())
        .descripcion(plantillaModel.getDescripcion())
        .etiqueta(plantillaModel.getEtiqueta())
        .fechaActualizacion(plantillaModel.getFechaActualizacion())
        .build();
    }
    
}
