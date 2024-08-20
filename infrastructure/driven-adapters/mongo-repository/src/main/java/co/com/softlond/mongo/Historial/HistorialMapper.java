package co.com.softlond.mongo.Historial;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.mongo.Collections.HistorialCollections;

public class HistorialMapper {

    public static HistorialModel toModel(HistorialCollections historialCollections){
        return HistorialModel.builder()
            .id(historialCollections.getId())
            .contador(historialCollections.getContador())
            .fechaUltimaModificacion(historialCollections.getFechaUltimaModificacion())
            .ultimaDecripcion(historialCollections.getUltimaDecripcion())
            .usuarioUltimaModificacion(historialCollections.getUsuarioUltimaModificacion())
            .build();
    }

    public static HistorialCollections toCollections(HistorialModel historialModel){
        return HistorialCollections.builder()
            .id(historialModel.getId())
            .contador(historialModel.getContador())
            .fechaUltimaModificacion(historialModel.getFechaUltimaModificacion())
            .ultimaDecripcion(historialModel.getUltimaDecripcion())
            .usuarioUltimaModificacion(historialModel.getUsuarioUltimaModificacion())
            .build();

    }
    
}


