package com.sena.caprendizaje.empleabilidad.service.port;

import java.util.List;

import com.sena.caprendizaje.empleabilidad.model.dto.MaestroParametroModel;
import com.sena.caprendizaje.empleabilidad.model.dto.ParametroModel;

public interface ParametrosServiceProvider {

    List<ParametroModel> handleRetrieveParametrosByMaestro(Long id);
    List<MaestroParametroModel> handleRetrieveMaestros();
    ParametroModel handleCreateParametro(ParametroModel model);
    ParametroModel handleUpdateParametro(ParametroModel model);
    MaestroParametroModel handleCreateMaestroParametro(MaestroParametroModel model);
    MaestroParametroModel handleUpdateMaestroParametro(MaestroParametroModel model);
    
}
