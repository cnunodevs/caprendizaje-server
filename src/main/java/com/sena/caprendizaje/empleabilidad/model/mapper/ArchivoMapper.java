package com.sena.caprendizaje.empleabilidad.model.mapper;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.ArchivoModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Archivo;
import com.sena.caprendizaje.shared.model.mapper.GenericMapper;

@Service
public class ArchivoMapper implements GenericMapper<ArchivoModel, Archivo> {

    @Override
    public ArchivoModel mapToModel(Archivo entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToModel'");
    }

    @Override
    public Archivo mapToEntity(ArchivoModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToEntity'");
    }
    
}
