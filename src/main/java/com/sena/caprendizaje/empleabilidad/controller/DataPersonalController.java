package com.sena.caprendizaje.empleabilidad.controller;

import java.util.HashMap;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.caprendizaje.empleabilidad.model.dto.DataPersonalModel;
import com.sena.caprendizaje.empleabilidad.service.port.DataPersonalServiceProvider;
import com.sena.caprendizaje.shared.constant.RestConstant;
import com.sena.caprendizaje.shared.message.Message;
import com.sena.caprendizaje.shared.response.ResponseManager;
import com.sena.caprendizaje.shared.response.StandardResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(RestConstant.Versioning.API_VERSION_1 + "/" + RestConstant.APPLICATION_NAME + "/"
        + RestConstant.Resources.DATA_PERSONAL)
@RequiredArgsConstructor
public class DataPersonalController implements ResponseManager {

    private final DataPersonalServiceProvider dataPersonalServiceProvider;

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> obtenerDataPersonalPorId(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(success(dataPersonalServiceProvider.obtenerDataPersonalPorId(id), Message.Success.SUCCESS));
    }

    @GetMapping
    public ResponseEntity<StandardResponse> listarDataPersonal(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "9") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.status(HttpStatus.OK).body(
                success(dataPersonalServiceProvider.listarDataPersonal(pageable), Message.Success.SUCCESS));
    }

    @PostMapping
    public ResponseEntity<StandardResponse> guardarDataPersonal(@RequestBody DataPersonalModel dataPersonalModel) {
        return ResponseEntity.status(HttpStatus.OK).body(
                success(dataPersonalServiceProvider.crearDataPersonal(dataPersonalModel), Message.Success.SUCCESS));
    }

    @PutMapping
    public ResponseEntity<StandardResponse> actualizarDataPersonal(@RequestBody DataPersonalModel dataPersonalModel) {
        return ResponseEntity.status(HttpStatus.OK).body(success(
                dataPersonalServiceProvider.editarDataPersonal(dataPersonalModel.getId(), dataPersonalModel),
                Message.Success.SUCCESS));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> eliminarDataPersonal(@PathVariable Long id) {
        boolean eliminar = dataPersonalServiceProvider.eliminarDataPersonalPorId(id);
        if (eliminar) {
            return ResponseEntity.status(HttpStatus.OK).body(success(new HashMap<>(), Message.Success.SUCCESS));
        }
        return ResponseEntity.status(HttpStatus.OK)
                .body(failed(new HashMap<>(), Message.Resources.DataPersonal.DATA_PERSONAL_NOT_FOUND));
    }

}
