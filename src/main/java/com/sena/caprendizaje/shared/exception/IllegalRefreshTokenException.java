package com.sena.caprendizaje.shared.exception;

public class IllegalRefreshTokenException extends InvalidTokenException {

    public IllegalRefreshTokenException(String message) {
        super(message);
    }
    
}
