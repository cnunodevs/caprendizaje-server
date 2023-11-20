package com.sena.caprendizaje.empleabilidad.model.dto;

import com.sena.caprendizaje.shared.model.dto.GenericModel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmpresaModel implements GenericModel {

    private Long id;

    private String nombre;

    private String codigo;

    private UsuarioModel administrador;

    private ArchivoModel fotoPerfil;
    
}
