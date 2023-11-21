package com.sena.caprendizaje.empleabilidad.service.adapter;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sena.caprendizaje.empleabilidad.model.enums.FileType;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Archivo;
import com.sena.caprendizaje.empleabilidad.persistence.repository.port.ArchivosRepository;
import com.sena.caprendizaje.empleabilidad.service.port.ArchivoServiceProvider;
import com.sena.caprendizaje.infrastructure.cloud.configuration.CloudEnvProvider;
import com.sena.caprendizaje.infrastructure.cloud.storage.service.adapter.CloudStorageServiceAdapter;

import lombok.RequiredArgsConstructor;



@Service
@RequiredArgsConstructor
public class ArchivoServiceAdapter implements ArchivoServiceProvider {

    private final CloudEnvProvider.PathProvider pathProvider;
    private final CloudEnvProvider.BucketEnvProvider bucketProvider;
    private final ArchivosRepository repository;
    private final CloudStorageServiceAdapter serviceAdapter;

    @Override
    public Archivo handleUploadProfilePic(MultipartFile file, String type) throws IOException {
        String path = "";
        InputStream inputStream = file.getInputStream();
        File fileRaw = File.createTempFile(file.getName(), "_file");
        fileRaw.deleteOnExit();
        try (FileOutputStream fileOutputStream = new FileOutputStream(fileRaw)) {
            byte[] buffer = new byte[8192];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
        }
        if(FileType.PERFILIMG.name().equals(type)) {
            path = pathProvider.getProfilepath();
        } else if(FileType.CV.name().equals(type)) {
            path = pathProvider.getCurriculumpath();
        }
        serviceAdapter.handleUploadFile(fileRaw, bucketProvider.getBucketname(), file.getName(), path);
        Archivo archivo = Archivo.builder().path(path).extension(file.getName().substring(file.getName().length() - 4, file.getName().length())).nombre(file.getName()).build();
        return repository.save(archivo);
    }

    @Override
    public String handleGetSignerUrl(Long id) throws IOException {
        Optional<Archivo> archivoOpt = repository.findById(id);
        if(!archivoOpt.isPresent()) {
            throw new IllegalArgumentException("no se encontro un archio asociado con ese id");
        }
        Archivo archivo = archivoOpt.get();
        String signerUrl = serviceAdapter.handleGenerateSignedUrl(bucketProvider.getBucketname(), archivo.getPath().concat(archivo.getNombre()));
        return signerUrl;
    }
    
}
