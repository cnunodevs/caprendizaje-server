package com.sena.caprendizaje.empleabilidad.model.dto;

import com.sena.caprendizaje.shared.model.dto.GenericModel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArchivoModel implements GenericModel {

    private Long id;

    private String path;

    private String nombre;

    private String extension;
    
}
