package com.sena.caprendizaje.aprendizaje.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sena.caprendizaje.shared.constant.RestConstant;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(RestConstant.Versioning.API_VERSION_1 + "/" + RestConstant.APPLICATION_NAME + "/" + RestConstant.Resources.POSTULATION_RESOURCE)
@RequiredArgsConstructor
public class PostulacionesController {
    
}
