package com.sena.caprendizaje.shared.model.mapper;

import com.sena.caprendizaje.shared.model.dto.GenericModel;
import com.sena.caprendizaje.shared.model.entity.GenericEntity;

public interface GenericMapper<D extends GenericModel, E extends GenericEntity> {

    D mapToModel(E entity);
    E mapToEntity(D model);
    
}
