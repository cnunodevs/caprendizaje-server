package com.sena.caprendizaje.empleabilidad.model.dto;

import com.sena.caprendizaje.shared.model.dto.GenericModel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsuarioModel implements GenericModel {

    private Long id;

    private DataPersonalModel datosPersonales;

    private String usuario;

    private String contraseña;

    private PerfilModel perfil;

    private Boolean activo;
    
}
