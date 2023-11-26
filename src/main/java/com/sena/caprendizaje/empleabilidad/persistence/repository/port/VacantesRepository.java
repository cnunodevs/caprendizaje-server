package com.sena.caprendizaje.empleabilidad.persistence.repository.port;

import java.util.List;

import com.sena.caprendizaje.empleabilidad.persistence.entity.Vacante;

public interface VacantesRepository {

    List<Vacante> handleRetrieveVacantes();
    Vacante handleCreateVacante(Vacante model);
    Vacante handleUpdateVacante(Vacante model);
    Vacante handleAprobarVacante(Vacante model);
    
}
