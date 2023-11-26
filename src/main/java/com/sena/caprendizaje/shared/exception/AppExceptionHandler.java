package com.sena.caprendizaje.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sena.caprendizaje.shared.response.ResponseManager;
import com.sena.caprendizaje.shared.response.StandardResponse;

import lombok.RequiredArgsConstructor;

@ControllerAdvice
@RequiredArgsConstructor
public class AppExceptionHandler implements ResponseManager {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<StandardResponse> exception(Exception exception) {
            exception.printStackTrace();
        return ResponseEntity.status(HttpStatus.OK).body(failed(exception.getLocalizedMessage()));
    }

}
