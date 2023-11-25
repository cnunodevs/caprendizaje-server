package com.sena.caprendizaje.empleabilidad.service.port;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.caprendizaje.empleabilidad.model.dto.UsuarioModel;

public interface UsuarioServiceProvider {

    UsuarioModel obtenerUsuarioPorId(Long id);

    UsuarioModel crearUsuario(UsuarioModel usuarioModel);

    Page<UsuarioModel> listarUsuarios(Pageable pageable);

    UsuarioModel editarUsuarioPorId(Long id, UsuarioModel usuarioModel);

    boolean eliminarUsuarioPorId(Long id);

}
