package co.com.softlond.mongo.Plantilla;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.com.softlond.model.PlantillaModel;
import co.com.softlond.model.gateways.PlantillaGateways;
import reactor.core.publisher.Mono;

@Repository
public class PlantillaGatewaysImpl implements PlantillaGateways{

    @Autowired
    private PlantillaRepository plantillaRepository;

    @Override
    public Mono<PlantillaModel> savePlantilla(PlantillaModel plantillaModel) {
        return plantillaRepository.save(PlantillaMapper.toCollections(plantillaModel))
        .map(savedCollections-> PlantillaMapper.toModel(savedCollections));
    }

    @Override
    public Mono<PlantillaModel> findById(String id) {
        return plantillaRepository.findById(id)
        .map(plantilla-> PlantillaMapper.toModel(plantilla));
    }
    
}
