package com.sena.caprendizaje.empleabilidad.service.adapter;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.MaestroParametroModel;
import com.sena.caprendizaje.empleabilidad.model.dto.ParametroModel;
import com.sena.caprendizaje.empleabilidad.service.port.ParametrosServiceProvider;

@Service
public class ParametrosServiceAdapter implements ParametrosServiceProvider {

    @Override
    public List<ParametroModel> handleRetrieveParametrosByMaestro(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleRetrieveParametrosByMaestro'");
    }

    @Override
    public List<MaestroParametroModel> handleRetrieveMaestros() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleRetrieveMaestros'");
    }

    @Override
    public ParametroModel handleCreateParametro(ParametroModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleCreateParametro'");
    }

    @Override
    public ParametroModel handleUpdateParametro(ParametroModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleUpdateParametro'");
    }

    @Override
    public MaestroParametroModel handleCreateMaestroParametro(MaestroParametroModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleCreateMaestroParametro'");
    }

    @Override
    public MaestroParametroModel handleUpdateMaestroParametro(MaestroParametroModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleUpdateMaestroParametro'");
    }
    
}
