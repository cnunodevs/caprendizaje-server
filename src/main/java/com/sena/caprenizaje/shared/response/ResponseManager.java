package com.sena.caprenizaje.shared.response;

import java.time.LocalDateTime;

import com.sena.caprenizaje.shared.message.Message;

public interface ResponseManager {

    default StandardResponse success(Object data, String message) {
        StandardResponse response = StandardResponse.builder()
                .status(Message.Success.SUCCESS)
                .localDateTime(LocalDateTime.now())
                .message(message)
                .data(data).build();
        return response;
    }

    default StandardResponse failed(Object data, String message) {
        StandardResponse response = StandardResponse.builder()
                .status(Message.Fail.FAIL)
                .localDateTime(LocalDateTime.now())
                .message(message)
                .data(data).build();
        return response;
    }

    default StandardResponse failed(String message) {
        StandardResponse response = StandardResponse.builder()
                .status(Message.Fail.FAIL)
                .localDateTime(LocalDateTime.now())
                .message(message).build();
        return response;
    }

    default StandardResponse error(Object data, String message) {
        StandardResponse response = StandardResponse.builder()
                .status(Message.Fail.FAIL)
                .localDateTime(LocalDateTime.now())
                .message(message)
                .data(data).build();
        return response;
    }

    default StandardResponse error(String message) {
        StandardResponse response = StandardResponse.builder()
                .status(Message.Fail.FAIL)
                .localDateTime(LocalDateTime.now())
                .message(message).build();
        return response;
    }

}
