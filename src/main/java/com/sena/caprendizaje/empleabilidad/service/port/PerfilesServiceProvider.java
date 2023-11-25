package com.sena.caprendizaje.empleabilidad.service.port;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.caprendizaje.empleabilidad.model.dto.PerfilModel;

public interface PerfilesServiceProvider {

    Page<PerfilModel> listarPerfiles(Pageable pageable);

    PerfilModel crearPerfil(PerfilModel perfil);

    PerfilModel obtenerPerfilPorId(Long id);

    PerfilModel editarPerfilPorId(Long id, PerfilModel perfil);

    boolean eliminarPerfilPorId(Long id);
}
