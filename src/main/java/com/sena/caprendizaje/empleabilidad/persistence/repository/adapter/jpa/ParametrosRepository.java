package com.sena.caprendizaje.empleabilidad.persistence.repository.adapter.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.caprendizaje.empleabilidad.persistence.entity.Parametro;

public interface ParametrosRepository extends JpaRepository<Parametro, Long> {

    List<Parametro> findByMaestroParametroId(Long maestroParametroId);
}
