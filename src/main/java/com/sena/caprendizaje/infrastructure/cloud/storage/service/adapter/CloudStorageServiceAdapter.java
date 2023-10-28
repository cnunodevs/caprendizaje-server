package com.sena.caprendizaje.infrastructure.cloud.storage.service.adapter;

import java.io.File;
import java.io.InputStream;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import com.sena.caprendizaje.infrastructure.cloud.storage.model.FileResult;
import com.sena.caprendizaje.infrastructure.cloud.storage.service.port.CloudStorageServiceProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CloudStorageServiceAdapter implements CloudStorageServiceProvider {

    private final AmazonS3 amazonS3;
    private final Logger logger = LoggerFactory.getLogger(CloudStorageServiceAdapter.class);

    @Override
    public FileResult handleUploadFile(File file, String bucket, String filename, String path) {
        String key = path + filename;
        PutObjectRequest request = new PutObjectRequest(bucket, key, file);
        amazonS3.putObject(request);
        logger.info("File uploaded to bucket: {} -> Filename: {}", bucket, filename);
        return FileResult.builder().key(key).url(handleGenerateSignedUrl(bucket, key)).build();
    }

    @Override
    public InputStream handleDownloadFile(String source, String key) {
        S3Object object = amazonS3.getObject(source, key);
        return object.getObjectContent();
    }

    @Override
    public String handleGenerateSignedUrl(String source, String key) {
        GeneratePresignedUrlRequest generatePresignedUrlRequest = new GeneratePresignedUrlRequest(source, key);
        generatePresignedUrlRequest.setMethod(HttpMethod.GET);
        URL signedUrl = amazonS3.generatePresignedUrl(generatePresignedUrlRequest);
        return signedUrl.toString();
    }
    
}
