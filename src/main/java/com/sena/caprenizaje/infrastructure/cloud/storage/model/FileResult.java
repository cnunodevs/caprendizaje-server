package com.sena.caprenizaje.infrastructure.cloud.storage.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FileResult {

    private String key;
    private String url;
    
}
