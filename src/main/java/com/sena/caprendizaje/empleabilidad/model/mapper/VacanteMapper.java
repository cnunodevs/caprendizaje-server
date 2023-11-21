package com.sena.caprendizaje.empleabilidad.model.mapper;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.VacanteModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Vacante;
import com.sena.caprendizaje.shared.model.mapper.GenericMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VacanteMapper implements GenericMapper<VacanteModel, Vacante> {

    private final EmpresaMapper empresaMapper;
    private final ParametroMapper parametroMapper;

    @Override
    public VacanteModel mapToModel(Vacante entity) {
        return VacanteModel.builder()
                .id(entity.getId())
                .activo(entity.getActivo()).salario(entity.getSalario())
                .nombre(entity.getNombre()).descripcion(entity.getDescripcion())
                .ciudad(entity.getCiudad() != null ? parametroMapper.mapToModel(entity.getCiudad()) : null)
                .moneda(entity.getMoneda() != null ? parametroMapper.mapToModel(entity.getMoneda()) : null)
                .modalidad(entity.getModalidad() != null ? parametroMapper.mapToModel(entity.getModalidad()) : null)
                .categoria(entity.getCategoria() != null ? parametroMapper.mapToModel(entity.getCategoria()) : null)
                .empresa(entity.getEmpresa() != null ? empresaMapper.mapToModel(entity.getEmpresa()) : null).build();
    }

    @Override
    public Vacante mapToEntity(VacanteModel model) {
        return Vacante.builder()
                .id(model.getId())
                .activo(model.getActivo()).salario(model.getSalario())
                .nombre(model.getNombre()).descripcion(model.getDescripcion())
                .ciudad(model.getCiudad() != null ? parametroMapper.mapToEntity(model.getCiudad()) : null)
                .moneda(model.getMoneda() != null ? parametroMapper.mapToEntity(model.getMoneda()) : null)
                .modalidad(model.getModalidad() != null ? parametroMapper.mapToEntity(model.getModalidad()) : null)
                .categoria(model.getCategoria() != null ? parametroMapper.mapToEntity(model.getCategoria()) : null)
                .empresa(model.getEmpresa() != null ? empresaMapper.mapToEntity(model.getEmpresa()) : null).build();
    }

}
