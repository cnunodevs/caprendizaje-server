package com.sena.caprendizaje.infrastructure.cloud.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;

import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class CloudProviderServicesConfiguration {

    private final KeyProvider keyProvider;

    @Bean
    AmazonS3 getAmazonS3() {
        return AmazonS3ClientBuilder.standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(
                        new StaticCredentialsProvider(
                            keyProvider.ACCESS_KEY, keyProvider.SECRET_KEY))
                .build();
    }

}
