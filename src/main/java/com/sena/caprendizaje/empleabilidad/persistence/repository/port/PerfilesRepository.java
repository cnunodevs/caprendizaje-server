package com.sena.caprendizaje.empleabilidad.persistence.repository.port;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.caprendizaje.empleabilidad.persistence.entity.Perfil;

public interface PerfilesRepository extends JpaRepository<Perfil, Long> {
    
}
