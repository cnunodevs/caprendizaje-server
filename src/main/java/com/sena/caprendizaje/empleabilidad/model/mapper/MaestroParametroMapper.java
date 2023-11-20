package com.sena.caprendizaje.empleabilidad.model.mapper;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.MaestroParametroModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.MaestroParametro;
import com.sena.caprendizaje.shared.model.mapper.GenericMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MaestroParametroMapper implements GenericMapper<MaestroParametroModel, MaestroParametro> {

    @Override
    public MaestroParametroModel mapToModel(MaestroParametro entity) {
        return MaestroParametroModel.builder().id(entity.getId()).nombre(entity.getNombre()).codigo(entity.getCodigo()).activo(entity.getActivo()).build();
    }

    @Override
    public MaestroParametro mapToEntity(MaestroParametroModel model) {
        return MaestroParametro.builder().id(model.getId()).nombre(model.getNombre()).codigo(model.getCodigo()).activo(model.getActivo()).build();
    }
    
}
