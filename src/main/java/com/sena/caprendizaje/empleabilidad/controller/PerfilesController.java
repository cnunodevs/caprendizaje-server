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

import com.sena.caprendizaje.empleabilidad.model.dto.PerfilModel;
import com.sena.caprendizaje.empleabilidad.service.port.PerfilesServiceProvider;
import com.sena.caprendizaje.shared.constant.RestConstant;
import com.sena.caprendizaje.shared.message.Message;
import com.sena.caprendizaje.shared.response.ResponseManager;
import com.sena.caprendizaje.shared.response.StandardResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(RestConstant.Versioning.API_VERSION_1 + "/" + RestConstant.APPLICATION_NAME + "/"
        + RestConstant.Resources.PROFILE_RESOURCE)
@RequiredArgsConstructor
public class PerfilesController implements ResponseManager {

    private final PerfilesServiceProvider perfilesServiceProvider;

    @GetMapping
    public ResponseEntity<StandardResponse> listarPerfiles(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "9") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.status(HttpStatus.OK)
                .body(success(perfilesServiceProvider.listarPerfiles(pageable), Message.Success.SUCCESS));
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> obtenerPerfilPorId(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(success(perfilesServiceProvider.obtenerPerfilPorId(id), Message.Success.SUCCESS));
    }

    @PostMapping
    public ResponseEntity<StandardResponse> crearPerfil(@RequestBody PerfilModel perfilModel) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(success(perfilesServiceProvider.crearPerfil(perfilModel), Message.Success.SUCCESS));
    }

    @PutMapping("/{id}")
    public ResponseEntity<StandardResponse> editarPerfilPorId(@RequestBody PerfilModel perfilModel,
            @PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(success(perfilesServiceProvider.editarPerfilPorId(id, perfilModel), Message.Success.SUCCESS));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StandardResponse> eliminaPerfilPorId(@PathVariable Long id) {
        boolean eliminado = perfilesServiceProvider.eliminarPerfilPorId(id);
        if (eliminado) {
            return ResponseEntity.status(HttpStatus.OK).body(success(new HashMap<>(), Message.Success.SUCCESS));
        }
        return ResponseEntity.status(HttpStatus.OK).body(failed(new HashMap<>(), Message.Resources.Perfil.PERFIL_NOT_FOUND));
    }
}
