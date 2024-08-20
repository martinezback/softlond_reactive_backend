package co.com.softlond.mongo.Historial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.model.gateways.HistorialGateways;
import co.com.softlond.mongo.Collections.HistorialCollections;
import reactor.core.publisher.Mono;

@Repository
public class HistorialGatewaysImpl  implements HistorialGateways{

    @Autowired
    private HistorialRepository historialRepository;

    @Override
    public Mono<HistorialModel> saveHistorial(HistorialModel historial) {
        return historialRepository.save(HistorialMapper.toCollections(historial))
        .map(historialCollections -> HistorialMapper.toModel(historialCollections));
    }

    @Override
    public Mono<HistorialModel> getHistorial() {
        
        Mono<HistorialCollections> historial= historialRepository.findAll().next();
        return historial.map(historialCollections->HistorialMapper.toModel(historialCollections));
    }

    
}
