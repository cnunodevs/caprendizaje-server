package com.sena.caprendizaje.empleabilidad.persistence.repository.adapter;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import com.sena.caprendizaje.empleabilidad.persistence.entity.Vacante;
import com.sena.caprendizaje.empleabilidad.persistence.repository.port.VacantesRepository;

@Repository
public class VacantesRepositoryAdapter implements VacantesRepository {

    @Override
    public List<Vacante> handleRetrieveVacantes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleRetrieveVacantes'");
    }

    @Override
    public List<Vacante> handleRetrieveVacantesByExample(Vacante model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleRetrieveVacantesByExample'");
    }

    @Override
    public Page<Vacante> handleRetrieveVacantesPaginated() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleRetrieveVacantesPaginated'");
    }

    @Override
    public Vacante handleCreateVacante(Vacante model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleCreateVacante'");
    }

    @Override
    public Vacante handleUpdateVacante(Vacante model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleUpdateVacante'");
    }

    @Override
    public Vacante handleAprobarVacante(Vacante model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleAprobarVacante'");
    }
    
}
