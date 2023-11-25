package com.sena.caprendizaje.empleabilidad.persistence.repository.port;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.caprendizaje.empleabilidad.persistence.entity.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Long> {

}
