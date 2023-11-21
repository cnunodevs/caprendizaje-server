package com.sena.caprendizaje.empleabilidad.service.adapter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.PostulacionModel;
import com.sena.caprendizaje.empleabilidad.model.mapper.PostulacionMapper;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Postulacion;
import com.sena.caprendizaje.empleabilidad.persistence.repository.port.PostulacionesRepository;
import com.sena.caprendizaje.empleabilidad.service.port.PostulacionServiceProvider;
import com.sena.caprendizaje.shared.message.Message;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostulacionServiceAdapter implements PostulacionServiceProvider {

    private final PostulacionMapper postulacionMapper;
    private final PostulacionesRepository postulacionesRepository;

    @Override
    public List<PostulacionModel> handleRetrievePostulaciones() {
        return postulacionesRepository.handleRetrievePostulaciones().stream().map(e -> postulacionMapper.mapToModel(e))
                .collect(Collectors.toList());
    }

    @Override
    public PostulacionModel handleCreatePostulacion(PostulacionModel model) {
        if (postulacionesRepository.handleAlreadyPostulado(model.getVacante().getId(), model.getUsuario().getId())) {
            throw new IllegalStateException(Message.Resources.Postulacion.ALREADY_POSTULADO);
        }
        Postulacion persisted = postulacionesRepository.handleCreatePostulacion(postulacionMapper.mapToEntity(model));
        return postulacionMapper.mapToModel(persisted);
    }

    @Override
    public PostulacionModel handleUpdatePostulacion(PostulacionModel model) {
        Postulacion entity = postulacionMapper.mapToEntity(model);
        if (!postulacionesRepository.handleAlreadyExists(entity)) {
            throw new IllegalStateException(Message.Resources.Postulacion.POSTULACION_NOT_FOUND);
        }
        Postulacion persisted = postulacionesRepository.handleUpdatePostulacion(entity);
        return postulacionMapper.mapToModel(persisted);
    }


}
