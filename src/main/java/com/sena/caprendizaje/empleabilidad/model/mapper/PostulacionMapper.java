package com.sena.caprendizaje.empleabilidad.model.mapper;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.PostulacionModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Postulacion;
import com.sena.caprendizaje.shared.model.mapper.GenericMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostulacionMapper implements GenericMapper<PostulacionModel, Postulacion> {

    private final UsuarioMapper usuarioMapper;
    private final VacanteMapper vacanteMapper;
    private final ParametroMapper parametroMapper;

    @Override
    public PostulacionModel mapToModel(Postulacion entity) {
        return PostulacionModel.builder().activa(entity.getActiva())
                .id(entity.getId())
                .vacante(entity.getVacante() != null ? vacanteMapper.mapToModel(entity.getVacante()) : null)
                .usuario(entity.getUsuario() != null ? usuarioMapper.mapToModel(entity.getUsuario()) : null) 
                .estado(entity.getEstado() != null ? parametroMapper.mapToModel(entity.getEstado()) : null).build();
    }

    @Override
    public Postulacion mapToEntity(PostulacionModel model) {
        return Postulacion.builder().activa(model.getActiva())
                .id(model.getId())
                .vacante(model.getVacante() != null ? vacanteMapper.mapToEntity(model.getVacante()) : null)
                .usuario(model.getUsuario() != null ? usuarioMapper.mapToEntity(model.getUsuario()) : null) 
                .estado(model.getEstado() != null ? parametroMapper.mapToEntity(model.getEstado()) : null).build();
    }

}
