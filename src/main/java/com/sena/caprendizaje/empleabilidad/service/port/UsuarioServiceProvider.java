package com.sena.caprendizaje.empleabilidad.service.port;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.caprendizaje.empleabilidad.model.dto.UsuarioModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Usuario;

public interface UsuarioServiceProvider {

    UsuarioModel obtenerUsuarioPorId(Long id);

    UsuarioModel crearUsuario(UsuarioModel usuarioModel);

    Page<UsuarioModel> listarUsuarios(Pageable pageable);

    UsuarioModel editarUsuarioPorId(Long id, UsuarioModel usuarioModel);

    boolean eliminarUsuarioPorId(Long id);

    Optional<Usuario> handleFindByUsuario(String usuario);


}
