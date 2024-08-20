package co.com.softlond.usecase.Plantilla;

import java.time.LocalDate;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.softlond.model.HistorialModel;
import co.com.softlond.model.PlantillaModel;
import co.com.softlond.model.UsuarioModel;
import co.com.softlond.model.gateways.PlantillaGateways;
import co.com.softlond.usecase.Historial.HistorialUseCase;
import co.com.softlond.usecase.Usuario.UsuarioUseCase;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
//import reactor.util.Logger;
//import reactor.util.Loggers;

@Service
public class PlantillaUseCase {

    @Autowired
    private PlantillaGateways plantillaGateways;

    @Autowired
    private UsuarioUseCase usuarioUseCase;

    @Autowired
    private HistorialUseCase historialUseCase;

    //private final Logger logger = Loggers.getLogger(PlantillaUseCase.class);


    public Mono<PlantillaModel> findById(String id){
        return plantillaGateways.findById(id);
    }


    public Mono<PlantillaModel> savePlantilla(PlantillaModel plantilla){
        plantilla.setVersion("1.0");
        plantilla.setFechaActualizacion(LocalDate.now());
        return plantillaGateways.savePlantilla(plantilla)
        .doOnSuccess(savedPlantilla->{
            createHistorial(plantilla)
            .subscribeOn(Schedulers.boundedElastic()).subscribe();
        });
    }

    private Mono<Void> createHistorial(PlantillaModel plantilla){
    
        return usuarioUseCase.findByUsername(plantilla.getAutor())
        .flatMap(user->{
                
            UsuarioModel usuario = UsuarioModel.builder()
            .nombre(user.getNombre())
            .username(user.getUsername())
            .dni(user.getDni())
            .build();
        
            return historialUseCase.getHistorial()
            .defaultIfEmpty(HistorialModel.builder()
            .usuarioUltimaModificacion(usuario)
            .ultimaDecripcion(plantilla.getDescripcion())
            .fechaUltimaModificacion(LocalDate.now())
            .build())
                .flatMap(history -> {
                    history.setContador(null== history.getContador() ? 1 : history.getContador()+1);
                    history.setUsuarioUltimaModificacion(usuario);
                    history.setUltimaDecripcion(plantilla.getDescripcion());
                    history.setFechaUltimaModificacion(LocalDate.now());
                    return historialUseCase.saveHistorial(history);
                });
        }).then();
    }


    public Mono<PlantillaModel> updatePlantilla(PlantillaModel plantilla){
        return plantillaGateways.findById(plantilla.getId())
        .flatMap(foundPlantilla->{
            plantilla.setVersion(modificarVersion(foundPlantilla, plantilla));
            foundPlantilla.setFechaActualizacion(LocalDate.now());
            return plantillaGateways.savePlantilla(plantilla)
            .doOnSuccess(updatedPlantilla->{
                updateHistorial(plantilla)
                .subscribeOn(Schedulers.boundedElastic()).subscribe();
            });
        });
    }


    private String modificarVersion
     (PlantillaModel plantillaRepository, PlantillaModel plantillaRequest){
        Boolean autor=Objects.equals(plantillaRequest.getAutor(), plantillaRepository.getAutor());
        Boolean nombre=Objects.equals(plantillaRequest.getNombre(), plantillaRepository.getNombre());
        Boolean categoria=Objects.equals(plantillaRequest.getCategoria(), plantillaRepository.getCategoria());
        Boolean activo=Objects.equals(plantillaRequest.getActivo(), plantillaRepository.getActivo());
        Boolean descripcion=Objects.equals(plantillaRequest.getDescripcion(), plantillaRepository.getDescripcion());
        Boolean etiqueta=Objects.equals(plantillaRequest.getEtiqueta(), plantillaRepository.getEtiqueta());

        String conditions = autor+"."+nombre+"."+categoria+"."+activo+"."+descripcion+"."+etiqueta;

        switch (conditions) {
            case "true.true.true.true.true.true":
                return plantillaRequest.getVersion();
            case "false.false.false.false.false.false":
                return updateVersion(plantillaRequest.getVersion());
            default:
                return patchVersion(plantillaRequest.getVersion());
        }
        
    }
    private String patchVersion (String version){
        String [] partes = version.split("\\.");
        Integer update = Integer.parseInt(partes[0]);
        Integer patch = Integer.parseInt(partes[1]);
        if(patch==5 ){
            update++; patch=0;
        }else if(patch <5){
            patch ++;
        }
        return update+ "."+ patch;
    }
    private String updateVersion (String version){
        String [] partes = version.split("\\.");
        Integer update = Integer.parseInt(partes[0]);
        Integer patch = Integer.parseInt(partes[1]);
        update++;
        patch=0;
        return update+ "."+ patch;
    }


    private Mono<Void> updateHistorial(PlantillaModel plantilla){
        return historialUseCase.getHistorial()
        .flatMap(history->{
            return usuarioUseCase.findByUsername(plantilla.getAutor())
            .flatMap(user->{
                UsuarioModel usuario = UsuarioModel.builder()
                .username(user.getUsername())
                .nombre(user.getNombre())
                .dni(user.getDni())
                .build();
                history.setUltimaDecripcion(plantilla.getDescripcion());
                history.setFechaUltimaModificacion(plantilla.getFechaActualizacion());
                history.setUsuarioUltimaModificacion(usuario);
                return historialUseCase.saveHistorial(history);
            });
        }).then();
    }


    
    
}
