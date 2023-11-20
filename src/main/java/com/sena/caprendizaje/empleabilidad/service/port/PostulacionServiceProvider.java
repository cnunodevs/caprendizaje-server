package com.sena.caprendizaje.empleabilidad.service.port;

import java.util.List;

import org.springframework.data.domain.Page;

import com.sena.caprendizaje.empleabilidad.model.dto.PostulacionModel;
import com.sena.caprendizaje.empleabilidad.model.dto.VacanteModel;

public interface PostulacionServiceProvider {

    List<PostulacionModel> handleRetrievePostulaciones();
    List<PostulacionModel> handleRetrievePostulacionesByExample(VacanteModel model);
    Page<PostulacionModel> handleRetrievePostulacionesPaginated();
    PostulacionModel handleCreatePostulacion(VacanteModel model);
    PostulacionModel handleUpdatePostulacion(VacanteModel model);

}
