package co.com.softlond.model.gateways;

import co.com.softlond.model.PlantillaModel;
import reactor.core.publisher.Mono;

public interface PlantillaGateways {

    Mono<PlantillaModel> savePlantilla(PlantillaModel plantillaModel);
    Mono<PlantillaModel> findById(String id);
    
}
