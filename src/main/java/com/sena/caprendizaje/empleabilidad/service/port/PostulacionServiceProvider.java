package com.sena.caprendizaje.empleabilidad.service.port;

import java.util.List;

import com.sena.caprendizaje.empleabilidad.model.dto.PostulacionModel;

public interface PostulacionServiceProvider {

    List<PostulacionModel> handleRetrievePostulaciones();
    PostulacionModel handleCreatePostulacion(PostulacionModel model);
    PostulacionModel handleUpdatePostulacion(PostulacionModel model);

}
