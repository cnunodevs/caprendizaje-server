package com.sena.caprendizaje.infrastructure.cloud.configuration;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import lombok.Data;

public class CloudEnvProvider {
    
    @Service
    @Data
    public static class PathProvider {
    
        protected String profilepath;
        protected String curriculumpath;

        protected PathProvider(Environment environment) {
            profilepath = environment.getProperty("cloud.aws.profilepict.path");
        }

    }

    @Service
    @Data
    public class KeyProvider {

        protected String ACCESS_KEY;
        protected String SECRET_KEY;
    
        protected KeyProvider(Environment environment) {
            ACCESS_KEY = environment.getProperty("cloud.aws.credentials.access-key");
            SECRET_KEY = environment.getProperty("cloud.aws.credentials.secret-key");
        }
        
    }

    @Service
    @Data
    public static class BucketEnvProvider {

        protected String bucketname;

        protected BucketEnvProvider(Environment environment) {
            bucketname = environment.getProperty("cloud.aws.s3.bucket");
        }


    }


}
