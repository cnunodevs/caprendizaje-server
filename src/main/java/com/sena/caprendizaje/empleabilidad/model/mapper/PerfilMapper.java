package com.sena.caprendizaje.empleabilidad.model.mapper;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.PerfilModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Perfil;
import com.sena.caprendizaje.shared.model.mapper.GenericMapper;

@Service
public class PerfilMapper implements GenericMapper<PerfilModel, Perfil> {

    @Override
    public PerfilModel mapToModel(Perfil entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToModel'");
    }

    @Override
    public Perfil mapToEntity(PerfilModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToEntity'");
    }
    
}
