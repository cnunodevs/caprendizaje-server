package com.sena.caprendizaje.empleabilidad.model.dto;

import com.sena.caprendizaje.empleabilidad.persistence.entity.Vacante;
import com.sena.caprendizaje.shared.model.dto.GenericModel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostulacionModel implements GenericModel {

    private Long id;

    private PostulacionModel postulacion;

    private Vacante vacante;

    private ParametroModel estado;

    private Boolean activa;
    
}
