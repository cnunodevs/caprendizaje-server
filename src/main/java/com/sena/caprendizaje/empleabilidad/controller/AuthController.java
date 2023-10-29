package com.sena.caprendizaje.empleabilidad.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.caprendizaje.shared.constant.RestConstant;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(RestConstant.Versioning.API_VERSION_1 + "/" + RestConstant.APPLICATION_NAME + "/" + RestConstant.Resources.AUTH_RESOURCE)
@RequiredArgsConstructor
public class AuthController {
    
}
