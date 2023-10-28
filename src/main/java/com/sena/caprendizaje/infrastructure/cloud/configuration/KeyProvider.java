package com.sena.caprendizaje.infrastructure.cloud.configuration;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class KeyProvider {

    protected String ACCESS_KEY;
    protected String SECRET_KEY;

    protected KeyProvider(Environment environment) {
        ACCESS_KEY = environment.getProperty("cloud.aws.credentials.access-key");
        SECRET_KEY = environment.getProperty("cloud.aws.credentials.secret-key");
    }
    
}