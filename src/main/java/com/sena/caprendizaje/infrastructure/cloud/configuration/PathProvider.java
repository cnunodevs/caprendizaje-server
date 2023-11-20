package com.sena.caprendizaje.infrastructure.cloud.configuration;

import org.springframework.core.env.Environment;

public class PathProvider {
    
    protected String profilepath;

    protected PathProvider(Environment environment) {
        profilepath = environment.getProperty("cloud.aws.profilepict.path");
    }

}
