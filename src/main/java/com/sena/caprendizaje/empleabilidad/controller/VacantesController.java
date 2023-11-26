package com.sena.caprendizaje.empleabilidad.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.caprendizaje.empleabilidad.model.dto.VacanteModel;
import com.sena.caprendizaje.empleabilidad.service.port.VacantesServiceProvider;
import com.sena.caprendizaje.shared.constant.RestConstant;
import com.sena.caprendizaje.shared.message.Message;
import com.sena.caprendizaje.shared.response.ResponseManager;
import com.sena.caprendizaje.shared.response.StandardResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(RestConstant.Versioning.API_VERSION_1 + "/" + RestConstant.APPLICATION_NAME + "/" + RestConstant.Resources.VACANT_RESOURCE)
@RequiredArgsConstructor
public class VacantesController implements ResponseManager {

    private final VacantesServiceProvider vacantesServiceProvider;

    @GetMapping
    public ResponseEntity<StandardResponse> handleRetrieveVacantes() {
        return ResponseEntity.status(HttpStatus.OK).body(success(vacantesServiceProvider.handleRetrieveVacantes(), Message.Success.SUCCESS_PROCESS));
    }

    @PostMapping
    public ResponseEntity<StandardResponse> handleCreateVacante(@RequestBody VacanteModel model) {
        return ResponseEntity.status(HttpStatus.CREATED).body(success(vacantesServiceProvider.handleCreateVacante(model), Message.Success.SUCCESS_PROCESS));
    }

    @PutMapping
    public ResponseEntity<StandardResponse> handleUpdateVacante(@RequestBody VacanteModel model) {
        return ResponseEntity.status(HttpStatus.OK).body(success(vacantesServiceProvider.handleUpdateVacante(model), Message.Success.SUCCESS_PROCESS));
    }

    @PatchMapping
    public ResponseEntity<StandardResponse> handleAprobarVacante(@RequestBody VacanteModel model) {
        return ResponseEntity.status(HttpStatus.OK).body(success(vacantesServiceProvider.handleAprobarVacante(model), Message.Success.SUCCESS_PROCESS));
    }
    
}
