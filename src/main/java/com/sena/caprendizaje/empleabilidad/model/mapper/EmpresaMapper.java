package com.sena.caprendizaje.empleabilidad.model.mapper;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.EmpresaModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Empresa;
import com.sena.caprendizaje.shared.model.mapper.GenericMapper;

@Service
public class EmpresaMapper implements GenericMapper<EmpresaModel, Empresa> {

    @Override
    public EmpresaModel mapToModel(Empresa entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToModel'");
    }

    @Override
    public Empresa mapToEntity(EmpresaModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToEntity'");
    }
    
}
