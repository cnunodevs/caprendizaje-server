package com.sena.caprendizaje.empleabilidad.persistence.repository.port;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.caprendizaje.empleabilidad.persistence.entity.Archivo;

public interface ArchivosRepository extends JpaRepository<Archivo, Long> {
    
}
