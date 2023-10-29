package com.sena.caprendizaje.empleabilidad.model.mapper;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.VacanteModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Vacante;
import com.sena.caprendizaje.shared.model.mapper.GenericMapper;

@Service
public class VacanteMapper implements GenericMapper<VacanteModel, Vacante> {

    @Override
    public VacanteModel mapToModel(Vacante entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToModel'");
    }

    @Override
    public Vacante mapToEntity(VacanteModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToEntity'");
    }
    
}
