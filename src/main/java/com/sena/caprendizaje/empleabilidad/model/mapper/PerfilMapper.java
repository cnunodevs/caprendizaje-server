package com.sena.caprendizaje.empleabilidad.model.mapper;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.PerfilModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Perfil;
import com.sena.caprendizaje.shared.model.mapper.GenericMapper;

@Service
public class PerfilMapper implements GenericMapper<PerfilModel, Perfil> {

    @Override
    public PerfilModel mapToModel(Perfil entity) {
        return PerfilModel.builder().id(entity.getId()).nombre(entity.getNombre()).codigo(entity.getCodigo())
                .desripcion(entity.getDesripcion()).activo(entity.getActivo()).build();
    }

    @Override
    public Perfil mapToEntity(PerfilModel model) {
        return Perfil.builder().id(model.getId()).nombre(model.getNombre()).codigo(model.getCodigo())
                .desripcion(model.getDesripcion()).activo(model.getActivo()).build();
    }

}
