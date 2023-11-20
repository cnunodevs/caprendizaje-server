package com.sena.caprendizaje.empleabilidad.model.dto;

import com.sena.caprendizaje.empleabilidad.persistence.entity.Empresa;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Parametro;
import com.sena.caprendizaje.shared.model.dto.GenericModel;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VacanteModel implements GenericModel {

    private Long id;

    private Double salario;
    
    private Parametro moneda;

    private Empresa empresa;

    private Parametro ciudad;

    private Parametro modalidad;

    private Parametro categoria;

    private Boolean activo;
    
}
