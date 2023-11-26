package com.sena.caprendizaje.empleabilidad.persistence.repository.adapter;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.sena.caprendizaje.empleabilidad.persistence.entity.Vacante;
import com.sena.caprendizaje.empleabilidad.persistence.repository.adapter.jpa.VacanteRepositoryJpa;
import com.sena.caprendizaje.empleabilidad.persistence.repository.port.VacantesRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class VacantesRepositoryAdapter implements VacantesRepository {

    private final VacanteRepositoryJpa repositoryJpa;

    @Override
    public List<Vacante> handleRetrieveVacantes() {
        return repositoryJpa.findAll();
    }

    @Override
    public Vacante handleCreateVacante(Vacante model) {
        return repositoryJpa.save(model);
    }

    @Override
    public Vacante handleUpdateVacante(Vacante model) {
        return repositoryJpa.save(model);
    }

    @Override
    public Vacante handleAprobarVacante(Vacante model) {
        if (repositoryJpa.handleAprobarVacante(model.getId()) > 0) {
            return repositoryJpa.findById(model.getId()).get();
        }
        return model;
    }
    
}
