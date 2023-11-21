package com.sena.caprendizaje.empleabilidad.model.mapper;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.UsuarioModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Usuario;
import com.sena.caprendizaje.shared.model.mapper.GenericMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioMapper implements GenericMapper<UsuarioModel, Usuario> {

    private final PerfilMapper perfilMapper;
    private final DataPersonalMapper dataPersonalMapper;

    @Override
    public UsuarioModel mapToModel(Usuario entity) {
        return UsuarioModel.builder().activo(entity.getActivo())
        .datosPersonales(entity.getDatosPersonales() != null ? dataPersonalMapper.mapToModel(entity.getDatosPersonales()) : null)
        .usuario(entity.getUsuario()).id(entity.getId())
        .perfil(entity.getPerfil() != null ? perfilMapper.mapToModel(entity.getPerfil()) : null)
        .build();
    }

    @Override
    public Usuario mapToEntity(UsuarioModel model) {
        return Usuario.builder().activo(model.getActivo())
        .datosPersonales(model.getDatosPersonales() != null ? dataPersonalMapper.mapToEntity(model.getDatosPersonales()) : null)
        .usuario(model.getUsuario()).id(model.getId())
        .perfil(model.getPerfil() != null ? perfilMapper.mapToEntity(model.getPerfil()) : null)
        .build();
    }
    
}
