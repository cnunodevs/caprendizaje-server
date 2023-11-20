package com.sena.caprendizaje.empleabilidad.service.port;

import org.springframework.data.domain.Page;
import java.util.List;

import com.sena.caprendizaje.empleabilidad.model.dto.VacanteModel;

public interface VacantesServiceProvider {

    List<VacanteModel> handleRetrieveVacantes();
    List<VacanteModel> handleRetrieveVacantesByExample(VacanteModel model);
    Page<VacanteModel> handleRetrieveVacantesPaginated();
    VacanteModel handleCreateVacante(VacanteModel model);
    VacanteModel handleUpdateVacante(VacanteModel model);
    VacanteModel handleAprobarVacante(VacanteModel model);

}
