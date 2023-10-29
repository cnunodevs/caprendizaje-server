package com.sena.caprendizaje.empleabilidad.model.mapper;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.ParametroModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Parametro;
import com.sena.caprendizaje.shared.model.mapper.GenericMapper;

@Service
public class ParametroMapper implements GenericMapper<ParametroModel, Parametro> {

    @Override
    public ParametroModel mapToModel(Parametro entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToModel'");
    }

    @Override
    public Parametro mapToEntity(ParametroModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToEntity'");
    }
    
}
