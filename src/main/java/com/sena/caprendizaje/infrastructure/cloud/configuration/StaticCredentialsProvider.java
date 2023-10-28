package com.sena.caprendizaje.infrastructure.cloud.configuration;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSCredentialsProvider;

public class StaticCredentialsProvider implements AWSCredentialsProvider {

    private final String accessKey;
    private final String secretKey;

    public StaticCredentialsProvider(String accessKey, String secretKey) {
        this.accessKey = accessKey;
        this.secretKey = secretKey;
    }

    @Override
    public AWSCredentials getCredentials() {
        return new AWSCredentials() {
            @Override
            public String getAWSAccessKeyId() {
                return accessKey;
            }

            @Override
            public String getAWSSecretKey() {
                return secretKey;
            }
        };
    }

    @Override
    public void refresh() {
        // No es necesario implementar este método para credenciales estáticas
    }
}