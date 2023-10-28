package com.sena.caprenizaje.infrastructure.cloud.storage.service.port;

import java.io.File;
import java.io.InputStream;

import com.sena.caprenizaje.infrastructure.cloud.storage.model.FileResult;

public interface CloudStorageServiceProvider {

    FileResult handleUploadFile(File file, String bucket, String filename, String path);
    InputStream handleDownloadFile(String source, String key);
    String handleGenerateSignedUrl(String source, String key);
    
}
