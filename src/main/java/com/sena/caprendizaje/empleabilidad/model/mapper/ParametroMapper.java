package com.sena.caprendizaje.empleabilidad.model.mapper;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.ParametroModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Parametro;
import com.sena.caprendizaje.shared.model.mapper.GenericMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParametroMapper implements GenericMapper<ParametroModel, Parametro> {

    private final MaestroParametroMapper maestroParametroMapper;

    @Override
    public ParametroModel mapToModel(Parametro entity) {
        return ParametroModel.builder().id(entity.getId()).nombre(entity.getNombre()).codigo(entity.getCodigo())
                .maestroParametro(entity.getMaestroParametro() != null
                        ? maestroParametroMapper.mapToModel(entity.getMaestroParametro())
                        : null)
                .activo(entity.getActivo()).build();
    }

    @Override
    public Parametro mapToEntity(ParametroModel model) {
        return Parametro.builder().id(model.getId()).nombre(model.getNombre()).codigo(model.getCodigo())
                .maestroParametro(model.getMaestroParametro() != null
                        ? maestroParametroMapper.mapToEntity(model.getMaestroParametro())
                        : null)
                .activo(model.getActivo()).build();
    }

}
