package com.sena.caprendizaje.empleabilidad.model.mapper;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.MaestroParametroModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.MaestroParametro;
import com.sena.caprendizaje.shared.model.mapper.GenericMapper;

@Service
public class MaestroParametroMapper implements GenericMapper<MaestroParametroModel, MaestroParametro> {

    @Override
    public MaestroParametroModel mapToModel(MaestroParametro entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToModel'");
    }

    @Override
    public MaestroParametro mapToEntity(MaestroParametroModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToEntity'");
    }
    
}
