package com.sena.caprendizaje.config.security.model;

import lombok.Data;

@Data
public class RefreshRequest {

    private String key;
    private String exp;
    private Long sub;
    
}
