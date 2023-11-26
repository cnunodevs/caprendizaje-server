package com.sena.caprendizaje.empleabilidad.service.port;

import java.util.List;

import com.sena.caprendizaje.empleabilidad.model.dto.VacanteModel;

public interface VacantesServiceProvider {

    List<VacanteModel> handleRetrieveVacantes();
    VacanteModel handleCreateVacante(VacanteModel model);
    VacanteModel handleUpdateVacante(VacanteModel model);
    VacanteModel handleAprobarVacante(VacanteModel model);

}
