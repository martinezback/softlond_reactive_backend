package co.com.softlond.usecase.Historial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.model.gateways.HistorialGateways;
import reactor.core.publisher.Mono;

@Service
public class HistorialUseCase {
    @Autowired
    private HistorialGateways historialGateways;

    
    public Mono<HistorialModel> saveHistorial(HistorialModel historialModel){
        
        return historialGateways.saveHistorial(historialModel);

    }

    public Mono<HistorialModel> getHistorial(){
        
        return historialGateways.getHistorial();

    }
}
