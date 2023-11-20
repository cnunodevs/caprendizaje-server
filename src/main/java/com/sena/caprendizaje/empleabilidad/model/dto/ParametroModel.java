package com.sena.caprendizaje.empleabilidad.model.dto;

import com.sena.caprendizaje.shared.model.dto.GenericModel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ParametroModel implements GenericModel {

    private Long id;

    private String nombre;

    private String codigo;

    private MaestroParametroModel maestroParametro;

    private Boolean activo;
    
}