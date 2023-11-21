package com.sena.caprendizaje.empleabilidad.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostulacionFilter {

    private Long vacante;
    private Long usuario;
    private Long estado;
    
}
