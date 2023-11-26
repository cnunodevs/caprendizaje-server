package com.sena.caprendizaje.empleabilidad.service.adapter;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.VacanteModel;
import com.sena.caprendizaje.empleabilidad.model.mapper.VacanteMapper;
import com.sena.caprendizaje.empleabilidad.persistence.repository.port.VacantesRepository;
import com.sena.caprendizaje.empleabilidad.service.port.VacantesServiceProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VacantesServiceAdapter implements VacantesServiceProvider {

    private final VacantesRepository vacantesRepository;
    private final VacanteMapper vacanteMapper;

    @Override
    public List<VacanteModel> handleRetrieveVacantes() {
        return vacantesRepository.handleRetrieveVacantes().stream().map(v -> vacanteMapper.mapToModel(v)).toList();
    }

    @Override
    public VacanteModel handleCreateVacante(VacanteModel model) {
        return vacanteMapper.mapToModel(vacantesRepository.handleCreateVacante(vacanteMapper.mapToEntity(model)));
    }

    @Override
    public VacanteModel handleUpdateVacante(VacanteModel model) {
        throw new UnsupportedOperationException("Unimplemented method 'handleUpdateVacante'");
    }

    @Override
    public VacanteModel handleAprobarVacante(VacanteModel model) {
        return vacanteMapper.mapToModel(vacantesRepository.handleAprobarVacante(vacanteMapper.mapToEntity(model))); 
    }
    
}
