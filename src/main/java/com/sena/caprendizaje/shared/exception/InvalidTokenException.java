package com.sena.caprendizaje.shared.exception;

import org.springframework.security.authentication.BadCredentialsException;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class InvalidTokenException extends BadCredentialsException {

    private String message;

    public InvalidTokenException(String message){
        super(message);
        this.message = message;
    }
    
}
