package com.sena.caprenizaje.shared.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.sena.caprenizaje.shared.message.Message;
import com.sena.caprenizaje.shared.response.ResponseManager;
import com.sena.caprenizaje.shared.response.StandardResponse;

import lombok.RequiredArgsConstructor;

@ControllerAdvice
@RequiredArgsConstructor
public class AppExceptionHandler implements ResponseManager {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.OK)
    public ResponseEntity<StandardResponse> exception(Exception exception) {
            exception.printStackTrace();
        return ResponseEntity.status(HttpStatus.OK).body(failed(Message.Fail.SOMETHING_WENT_WRONG));
    }
    
}
