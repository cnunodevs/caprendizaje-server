package com.sena.caprendizaje.config.security.model;

import java.util.List;

import com.sena.caprendizaje.shared.exception.IllegalRefreshTokenException;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString 
public class SecretyKey {

    private String subject;
    private String entity;

    public SecretyKey(String subject, String entity) {
        this.entity = entity;
        this.subject = subject;
    }

    public static SecretyKey keyMapper(List<String> params) throws IllegalRefreshTokenException {
        if (params.size() != 3) {
            throw new IllegalRefreshTokenException("Illegal refresh key params");
        }
        final String subject = params.get(0);
        final String entity = params.get(1);
        return new SecretyKey(subject, entity);
    }

}
