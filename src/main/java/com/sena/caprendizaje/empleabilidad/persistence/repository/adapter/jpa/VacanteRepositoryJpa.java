package com.sena.caprendizaje.empleabilidad.persistence.repository.adapter.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.sena.caprendizaje.empleabilidad.persistence.entity.Vacante;

import jakarta.transaction.Transactional;

public interface VacanteRepositoryJpa extends JpaRepository<Vacante, Long> {

    @Modifying
    @Transactional
    @Query(value = "update vacantes set aprobada = true where id = :id", nativeQuery = true)
    int handleAprobarVacante(Long id);
    
}
