package com.sena.caprendizaje.empleabilidad.controller;

import java.util.HashMap;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sena.caprendizaje.empleabilidad.model.dto.EmpresaModel;
import com.sena.caprendizaje.empleabilidad.model.dto.UsuarioModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Empresa;
import com.sena.caprendizaje.empleabilidad.service.port.EmpresasServiceProvider;
import com.sena.caprendizaje.shared.constant.RestConstant;
import com.sena.caprendizaje.shared.message.Message;
import com.sena.caprendizaje.shared.response.ResponseManager;
import com.sena.caprendizaje.shared.response.StandardResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(RestConstant.Versioning.API_VERSION_1 + "/" + RestConstant.APPLICATION_NAME + "/" + RestConstant.Resources.COMPANY)
@RequiredArgsConstructor
public class EmpresasController implements ResponseManager {
    
    private final EmpresasServiceProvider emaresasServiceProvider;


    @GetMapping
        public ResponseEntity<StandardResponse> listarUsuarios(@RequestParam(defaultValue = "0") int page,
                        @RequestParam(defaultValue = "9") int size) {
                Pageable pageable = PageRequest.of(page, size);
                return ResponseEntity.status(HttpStatus.OK)
                                .body(success(emaresasServiceProvider.handleFindAllPaginate(pageable),
                                                Message.Success.SUCCESS));
        }

        @GetMapping("/{id}")
        public ResponseEntity<StandardResponse> obtenerUsuarioPorId(@PathVariable("id") Long id) {
                return ResponseEntity.status(HttpStatus.OK)
                                .body(success(emaresasServiceProvider.handleAlreadyExistById(id),
                                                Message.Success.SUCCESS));
        }

        @PostMapping
        public ResponseEntity<StandardResponse> guardarUsuario(@RequestBody Empresa usuarioModel) {
                return ResponseEntity.status(HttpStatus.OK)
                                .body(success(emaresasServiceProvider.handleCreateNewRegister(usuarioModel),
                                                Message.Success.SUCCESS));
        }

        @PutMapping
        public ResponseEntity<StandardResponse> editarUsuario(@RequestBody Empresa usuarioModel) {
                return ResponseEntity.status(HttpStatus.OK)
                                .body(success(emaresasServiceProvider.handleUpdate(usuarioModel), Message.Success.SUCCESS));
        }

        @DeleteMapping("/{id}")
        public ResponseEntity<StandardResponse> eliminarEmpresa(@PathVariable("id") Long id) {
                boolean eliminado = emaresasServiceProvider.handleDeleteById(id);
                if (eliminado) {
                        return ResponseEntity.status(HttpStatus.OK)
                                        .body(success(new HashMap<>(), Message.Success.SUCCESS));
                }
                return ResponseEntity.status(HttpStatus.OK)
                                .body(failed(new HashMap<>(), Message.Resources.Usuario.USUARIO_NOT_FOUND));
        }



    
}
