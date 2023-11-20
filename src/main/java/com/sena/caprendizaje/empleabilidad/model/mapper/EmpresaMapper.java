package com.sena.caprendizaje.empleabilidad.model.mapper;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.EmpresaModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Empresa;
import com.sena.caprendizaje.shared.model.mapper.GenericMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmpresaMapper implements GenericMapper<EmpresaModel, Empresa> {

    private final ArchivoMapper archivoMapper;
    private final UsuarioMapper usuarioMapper;

    @Override
    public EmpresaModel mapToModel(Empresa entity) {
        return EmpresaModel.builder().id(entity.getId()).nombre(entity.getNombre()).codigo(entity.getCodigo())
                .administrador(entity.getAdministrador() != null ? usuarioMapper.mapToModel(entity.getAdministrador()) : null)
                .fotoPerfil(entity.getFotoPerfil() != null ? archivoMapper.mapToModel(entity.getFotoPerfil()) : null)
                .build();
    }

    @Override
    public Empresa mapToEntity(EmpresaModel model) {
        return Empresa.builder().id(model.getId()).nombre(model.getNombre()).codigo(model.getCodigo())
                .administrador(model.getAdministrador() != null ? usuarioMapper.mapToEntity(model.getAdministrador()) : null)
                .fotoPerfil(model.getFotoPerfil() != null ? archivoMapper.mapToEntity(model.getFotoPerfil()) : null)
                .build();
    }

}
