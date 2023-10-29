package com.sena.caprendizaje.empleabilidad.model.mapper;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.DataPersonalModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.DataPersonal;
import com.sena.caprendizaje.shared.model.mapper.GenericMapper;

@Service
public class DataPersonalMapper implements GenericMapper<DataPersonalModel, DataPersonal> {

    @Override
    public DataPersonalModel mapToModel(DataPersonal entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToModel'");
    }

    @Override
    public DataPersonal mapToEntity(DataPersonalModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToEntity'");
    }
    
}
