package com.sena.caprendizaje.empleabilidad.model.dto;

import com.sena.caprendizaje.shared.model.dto.GenericModel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VacanteModel implements GenericModel {

    private Long id;

    private String nombre;

    private String descripcion;

    private Double salario;
    
    private ParametroModel moneda;

    private EmpresaModel empresa;

    private ParametroModel ciudad;

    private ParametroModel modalidad;

    private ParametroModel categoria;

    private Boolean activo;
    
}
