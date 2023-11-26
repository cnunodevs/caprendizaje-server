package com.sena.caprendizaje.config.security.service;

import java.util.Optional;

import org.apache.http.auth.InvalidCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sena.caprendizaje.config.security.model.AuthenticationRequest;
import com.sena.caprendizaje.config.security.model.AuthenticationResponse;
import com.sena.caprendizaje.config.security.model.RefreshRequest;
import com.sena.caprendizaje.config.security.model.RefreshResponse;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Usuario;
import com.sena.caprendizaje.empleabilidad.service.port.UsuarioServiceProvider;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    
    private final AppUserDetailsService userDetailsService;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;


    public AuthenticationResponse authenticate(AuthenticationRequest request) throws InvalidCredentialsException {
        System.out.println("username: " + request.getUsername());
        UserDetails usuario = userDetailsService.loadUserByUsername(request.getUsername());
        if (!passwordEncoder.matches(request.getPassword(), usuario.getPassword())) {
            throw new InvalidCredentialsException("Usuario o contraseña erroneos");
        }

        if (!userDetailsService.validateUserAndProfile(request.getUsername())) {
            throw new InvalidCredentialsException("Usuario o perfil inactivo");
        }
        String jwtToken = jwtService.generateToken(usuario);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public RefreshResponse refreshToken(RefreshRequest request) {
        RefreshResponse response = new RefreshResponse(jwtService.refreshToken(request)); 
        return response;
    }

    public Boolean isTokenValid(String token) throws Exception {
        return jwtService.isTokenValid(token);
    }

}
