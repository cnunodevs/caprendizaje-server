package com.sena.caprendizaje.empleabilidad.model.mapper;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.ArchivoModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Archivo;
import com.sena.caprendizaje.shared.model.mapper.GenericMapper;

@Service
public class ArchivoMapper implements GenericMapper<ArchivoModel, Archivo> {

    @Override
    public ArchivoModel mapToModel(Archivo entity) {
        return ArchivoModel.builder().id(entity.getId()).path(entity.getPath()).nombre(entity.getNombre())
                .extension(entity.getExtension()).build();
    }

    @Override
    public Archivo mapToEntity(ArchivoModel model) {
        return Archivo.builder().id(model.getId()).path(model.getPath()).nombre(model.getNombre())
                .extension(model.getExtension()).build();
    }

}
