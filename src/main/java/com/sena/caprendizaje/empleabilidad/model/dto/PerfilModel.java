package com.sena.caprendizaje.empleabilidad.model.dto;

import com.sena.caprendizaje.shared.model.dto.GenericModel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PerfilModel implements GenericModel {

    private Long id;

    private String nombre;

    private String desripcion;

    private String codigo;

    private Boolean activo;
    
}
