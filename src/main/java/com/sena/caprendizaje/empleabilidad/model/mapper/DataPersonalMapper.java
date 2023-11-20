package com.sena.caprendizaje.empleabilidad.model.mapper;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.DataPersonalModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.DataPersonal;
import com.sena.caprendizaje.shared.model.mapper.GenericMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DataPersonalMapper implements GenericMapper<DataPersonalModel, DataPersonal> {

    private final ArchivoMapper archivoMapper;
    private final ParametroMapper parametroMapper;

    @Override
    public DataPersonalModel mapToModel(DataPersonal entity) {
        return DataPersonalModel.builder().id(entity.getId()).descripcion(entity.getDescripcion())
                .email(entity.getEmail()).telefono(entity.getTelefono()).documento(entity.getDocumento())
                .profesion(entity.getProfesion() != null ? parametroMapper.mapToModel(entity.getProfesion()) : null)
                .tipoDocumento(entity.getTipoDocumento() != null ? parametroMapper.mapToModel(entity.getTipoDocumento()) : null)
                .curriculum(entity.getCurriculum() != null ? archivoMapper.mapToModel(entity.getCurriculum()) : null)
                .build();
    }

    @Override
    public DataPersonal mapToEntity(DataPersonalModel model) {
        return DataPersonal.builder().id(model.getId()).descripcion(model.getDescripcion())
                .email(model.getEmail()).telefono(model.getTelefono()).documento(model.getDocumento())
                .profesion(model.getProfesion() != null ? parametroMapper.mapToEntity(model.getProfesion()) : null)
                .tipoDocumento(model.getTipoDocumento() != null ? parametroMapper.mapToEntity(model.getTipoDocumento()) : null)
                .curriculum(model.getCurriculum() != null ? archivoMapper.mapToEntity(model.getCurriculum()) : null)
                .build();
    }

}
