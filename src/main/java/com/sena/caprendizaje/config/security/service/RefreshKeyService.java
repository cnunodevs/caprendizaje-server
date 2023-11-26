package com.sena.caprendizaje.config.security.service;

import static com.sena.caprendizaje.config.security.constant.SecurityConstants.SUBFIX_REFRESH;

import java.util.Base64;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.config.security.model.SecretyKey;



@Service
public class RefreshKeyService {

    public boolean validatedSecretKey(String username, String subject, String encodedKey) {
        SecretyKey decoded = decodeRefreshKey(encodedKey);
        System.out.println(decoded.toString());
        return username.trim().equalsIgnoreCase(decoded.getEntity()) && subject.trim().equalsIgnoreCase(decoded.getSubject());
    }

    public String generateRefreshKey(String subject, String entity) {
        String subfix = generateSubfix();
        String plainKey = String.format("%s#%s#%s", subject, entity, subfix);
        byte[] plainKeyBytes = plainKey.getBytes();
        byte[] encodedBytes = Base64.getEncoder().encode(plainKeyBytes);
        return new String(encodedBytes);
    }

    private SecretyKey decodeRefreshKey(String encodedKey) {
        byte[] decodedBytes = Base64.getDecoder().decode(encodedKey);
        String decodedString = new String(decodedBytes);
        return SecretyKey.keyMapper(List.of(decodedString.split("#")));
    }

    private String generateSubfix() {
        Random random = new Random();
        int min = (int) Math.pow(10, SUBFIX_REFRESH - 1);
        int max = (int) Math.pow(10, SUBFIX_REFRESH) - 1;
        int randomNumber = random.nextInt(max - min + 1) + min;
        return String.valueOf(randomNumber);
    }

}
