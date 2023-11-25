package com.sena.caprendizaje.empleabilidad.persistence.repository.adapter.jpa;


import org.springframework.data.jpa.repository.JpaRepository;

import com.sena.caprendizaje.empleabilidad.persistence.entity.MaestroParametro;

public interface MaestroParametrosRepository extends JpaRepository<MaestroParametro, Long>{
    
}
