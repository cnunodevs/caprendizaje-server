package com.sena.caprendizaje.empleabilidad.model.dto;

import com.sena.caprendizaje.shared.model.dto.GenericModel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DataPersonalModel implements GenericModel {

    private Long id;

    private String descripcion;
    
    private String email;
    
    private String telefono;

    private String documento;

    private ParametroModel profesion;

    private ParametroModel tipoDocumento;

    private ArchivoModel curriculum;
    
}
