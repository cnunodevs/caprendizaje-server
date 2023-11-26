package com.sena.caprendizaje.empleabilidad.controller;

import org.apache.http.auth.InvalidCredentialsException;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.caprendizaje.config.security.model.AuthenticationRequest;
import com.sena.caprendizaje.config.security.model.AuthenticationResponse;
import com.sena.caprendizaje.config.security.model.RefreshRequest;
import com.sena.caprendizaje.config.security.model.RefreshResponse;
import com.sena.caprendizaje.config.security.service.AuthenticationService;
import com.sena.caprendizaje.shared.constant.RestConstant;
import com.sena.caprendizaje.shared.exception.IllegalRefreshTokenException;
import com.sena.caprendizaje.shared.response.ResponseManager;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(RestConstant.Versioning.API_VERSION_1 + "/" + RestConstant.APPLICATION_NAME + "/" + RestConstant.Resources.AUTH_RESOURCE)
@RequiredArgsConstructor
public class AuthController implements ResponseManager {
    
    private final AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody final AuthenticationRequest request) throws InvalidCredentialsException {
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.authenticate(request));
    }

    @GetMapping("verifie-token")
    public ResponseEntity<AuthenticationResponse> verifieToken(@RequestParam String token) throws Exception {
        AuthenticationResponse autResponse = new AuthenticationResponse();
        autResponse.setToken((authenticationService.isTokenValid(token)) ? token : null);
        return ResponseEntity.status(HttpStatus.OK).body(autResponse);
    }

    @PostMapping("refresh")
    public ResponseEntity<RefreshResponse> refreshToken(
            @RequestBody final RefreshRequest request) throws IllegalRefreshTokenException {
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.refreshToken(request));
    }

    /**
     * 
     * Inicializa el enlace de datos para el controlador.
     * 
     * @param binder El WebDataBinder utilizado para enlazar los datos de solicitud.
     */
    @InitBinder
    public void initBinder(final WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }

}
