package com.sena.caprendizaje.empleabilidad.model.mapper;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.UsuarioModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Usuario;
import com.sena.caprendizaje.shared.model.mapper.GenericMapper;

@Service
public class UsuarioMapper implements GenericMapper<UsuarioModel, Usuario> {

    @Override
    public UsuarioModel mapToModel(Usuario entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToModel'");
    }

    @Override
    public Usuario mapToEntity(UsuarioModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToEntity'");
    }
    
}
