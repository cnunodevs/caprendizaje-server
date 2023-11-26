package com.sena.caprendizaje.shared.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

    private String status;
    private String message; 
    private Object data;
    
}
