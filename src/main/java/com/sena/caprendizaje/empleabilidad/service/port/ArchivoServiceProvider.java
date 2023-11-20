package com.sena.caprendizaje.empleabilidad.service.port;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.sena.caprendizaje.empleabilidad.model.dto.ArchivoModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Archivo;

public interface ArchivoServiceProvider {
    
    Archivo handleUploadProfilePic(MultipartFile file, String type) throws IOException;
    String handleGetSignerUrl(Long id) throws IOException;

}
