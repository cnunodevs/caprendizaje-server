package com.sena.caprendizaje.empleabilidad.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.caprendizaje.empleabilidad.model.dto.PostulacionModel;
import com.sena.caprendizaje.empleabilidad.service.port.PostulacionServiceProvider;
import com.sena.caprendizaje.shared.constant.RestConstant;
import com.sena.caprendizaje.shared.message.Message;
import com.sena.caprendizaje.shared.response.ResponseManager;
import com.sena.caprendizaje.shared.response.StandardResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(RestConstant.Versioning.API_VERSION_1 + "/" + RestConstant.APPLICATION_NAME + "/" + RestConstant.Resources.POSTULATION_RESOURCE)
@RequiredArgsConstructor
public class PostulacionesController implements ResponseManager {

    private final PostulacionServiceProvider postulacionServiceProvider;

    @GetMapping
    public ResponseEntity<StandardResponse> handleRetrievePostulaciones() {
        return ResponseEntity.status(HttpStatus.OK).body(success(postulacionServiceProvider.handleRetrievePostulaciones(), Message.Success.SUCCESS));
    }

    @PostMapping
    public ResponseEntity<StandardResponse> handleCreatePostulacion(@RequestBody PostulacionModel model) {
        return ResponseEntity.status(HttpStatus.CREATED).body(success(postulacionServiceProvider.handleCreatePostulacion(model), Message.Success.SUCCESS_PROCESS));
    }

    @PostMapping
    public ResponseEntity<StandardResponse> handleUpdatePostulacion(@RequestBody PostulacionModel model) {
        return ResponseEntity.status(HttpStatus.OK).body(success(postulacionServiceProvider.handleUpdatePostulacion(model), Message.Success.SUCCESS_PROCESS));
    }
    
}
