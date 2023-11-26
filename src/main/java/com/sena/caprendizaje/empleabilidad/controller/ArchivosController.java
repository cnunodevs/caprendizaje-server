package com.sena.caprendizaje.empleabilidad.controller;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sena.caprendizaje.empleabilidad.model.dto.ArchivoModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Archivo;
import com.sena.caprendizaje.empleabilidad.service.port.ArchivoServiceProvider;
import com.sena.caprendizaje.shared.constant.RestConstant;
import com.sena.caprendizaje.shared.message.Message;
import com.sena.caprendizaje.shared.response.ResponseManager;
import com.sena.caprendizaje.shared.response.StandardResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(RestConstant.Versioning.API_VERSION_1 + "/" + RestConstant.APPLICATION_NAME + "/" + RestConstant.Resources.UPLOAD_RESOURCE)
@RequiredArgsConstructor
public class ArchivosController implements ResponseManager {
    
    private final ArchivoServiceProvider service;

    @PostMapping("upload/picture")
    public ResponseEntity<StandardResponse> handleUploadPicture(@RequestBody MultipartFile file, @RequestParam String type) throws IOException {
        Archivo archivo = service.handleUploadProfilePic(file, type);
        ArchivoModel model = ArchivoModel.builder().nombre(archivo.getNombre()).extension(archivo.getExtension()).path(archivo.getPath()).build();
        return ResponseEntity.status(HttpStatus.OK).body(success(model, Message.Success.SUCCESS)); 
    }

    @GetMapping
    public ResponseEntity<StandardResponse> handleGetSignerUrl(@RequestBody Long idFile) throws IOException {
        return ResponseEntity.status(HttpStatus.OK).body(success(service.handleGetSignerUrl(idFile), "signed url"));
    }

}
