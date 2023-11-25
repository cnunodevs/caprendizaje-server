package com.sena.caprendizaje.empleabilidad.controller;

import com.sena.caprendizaje.empleabilidad.model.dto.MaestroParametroModel;
import com.sena.caprendizaje.empleabilidad.model.dto.ParametroModel;
import com.sena.caprendizaje.empleabilidad.service.port.ParametrosServiceProvider;
import com.sena.caprendizaje.shared.constant.RestConstant;
import com.sena.caprendizaje.shared.message.Message;
import com.sena.caprendizaje.shared.response.ResponseManager;
import com.sena.caprendizaje.shared.response.StandardResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(RestConstant.Versioning.API_VERSION_1 + "/" + RestConstant.APPLICATION_NAME + "/"
                + RestConstant.Resources.PARAMETROS)
@RequiredArgsConstructor
public class ParametrosController implements ResponseManager {

        private final ParametrosServiceProvider parametrosProvider;

        @GetMapping("/listParametrosByMaestro/{maestroId}")
        public ResponseEntity<StandardResponse> listParametros(@PathVariable("maestroId") Long id) {
                return ResponseEntity.status(HttpStatus.OK)
                                .body(success(parametrosProvider.handleRetrieveParametrosByMaestro(id),
                                                Message.Success.SUCCESS));
        }

        @GetMapping("/listMaestros")
        public ResponseEntity<StandardResponse> listMaestros() {
                return ResponseEntity.status(HttpStatus.OK)
                                .body(success(parametrosProvider.handleRetrieveMaestros(), Message.Success.SUCCESS));
        }

        @PostMapping("/createParametro")
        public ResponseEntity<StandardResponse> createParametro(@RequestBody ParametroModel parametroModel) {
                return ResponseEntity.status(HttpStatus.OK)
                                .body(success(parametrosProvider.handleCreateParametro(parametroModel),
                                                Message.Success.SUCCESS));
        }

        @PostMapping("/createMaestro")
        public ResponseEntity<StandardResponse> createMaestro(@RequestBody MaestroParametroModel mParametroModel) {
                return ResponseEntity.status(HttpStatus.OK)
                                .body(success(parametrosProvider.handleCreateMaestroParametro(mParametroModel),
                                                Message.Success.SUCCESS));
        }

        @PutMapping("/updateParametro")
        public ResponseEntity<StandardResponse> updateParametro(@RequestBody ParametroModel parametroModel) {
                return ResponseEntity.status(HttpStatus.OK)
                                .body(success(parametrosProvider.handleUpdateParametro(parametroModel),
                                                Message.Success.SUCCESS));
        }

        @PutMapping("/updateMaestro")
        public ResponseEntity<StandardResponse> updateMaestro(@RequestBody MaestroParametroModel mParametroModel) {
                return ResponseEntity.status(HttpStatus.OK)
                                .body(success(parametrosProvider.handleUpdateMaestroParametro(mParametroModel),
                                                Message.Success.SUCCESS));
        }
}
