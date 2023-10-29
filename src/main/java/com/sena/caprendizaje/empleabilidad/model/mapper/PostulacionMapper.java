package com.sena.caprendizaje.empleabilidad.model.mapper;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.PostulacionModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Postulacion;
import com.sena.caprendizaje.shared.model.mapper.GenericMapper;

@Service
public class PostulacionMapper implements GenericMapper<PostulacionModel, Postulacion>  {

    @Override
    public PostulacionModel mapToModel(Postulacion entity) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToModel'");
    }

    @Override
    public Postulacion mapToEntity(PostulacionModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mapToEntity'");
    }
    
}
