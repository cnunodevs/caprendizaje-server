package com.sena.caprendizaje.empleabilidad.persistence.repository.port;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import com.sena.caprendizaje.empleabilidad.model.dto.PostulacionFilter;
import com.sena.caprendizaje.empleabilidad.model.dto.PostulacionModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Postulacion;

public interface PostulacionesRepository {

    Boolean handleAlreadyPostulado(Long vacante, Long postulante);
    List<Postulacion> handleRetrievePostulaciones();
    List<Postulacion> handleRetrievePostulacionesByExample(Postulacion model);
    Optional<Postulacion> handleFindPostulacionById(Long id);
    Boolean handleAlreadyExists(Postulacion model);
    Page<Postulacion> handleRetrievePostulacionesPaginated();
    Postulacion handleCreatePostulacion(Postulacion model);
    Postulacion handleUpdatePostulacion(Postulacion model);
    PostulacionModel handleRetrievePostulacionFiltered(PostulacionFilter filter);
    
}
