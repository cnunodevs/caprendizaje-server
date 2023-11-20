package com.sena.caprendizaje.empleabilidad.service.adapter;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.VacanteModel;
import com.sena.caprendizaje.empleabilidad.service.port.VacantesServiceProvider;

@Service
public class VacantesServiceAdapter implements VacantesServiceProvider {

    @Override
    public List<VacanteModel> handleRetrieveVacantes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleRetrieveVacantes'");
    }

    @Override
    public List<VacanteModel> handleRetrieveVacantesByExample(VacanteModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleRetrieveVacantesByExample'");
    }

    @Override
    public Page<VacanteModel> handleRetrieveVacantesPaginated() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleRetrieveVacantesPaginated'");
    }

    @Override
    public VacanteModel handleCreateVacante(VacanteModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleCreateVacante'");
    }

    @Override
    public VacanteModel handleUpdateVacante(VacanteModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleUpdateVacante'");
    }

    @Override
    public VacanteModel handleAprobarVacante(VacanteModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleAprobarVacante'");
    }
    
}
