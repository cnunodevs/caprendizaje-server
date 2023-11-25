package com.sena.caprendizaje.empleabilidad.service.port;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sena.caprendizaje.empleabilidad.model.dto.DataPersonalModel;

public interface DataPersonalServiceProvider {

    DataPersonalModel obtenerDataPersonalPorId(Long id);

    DataPersonalModel crearDataPersonal(DataPersonalModel dataPersonalModel);

    Page<DataPersonalModel> listarDataPersonal(Pageable pageable);

    DataPersonalModel editarDataPersonal(Long id, DataPersonalModel dataPersonalModel);

    boolean eliminarDataPersonalPorId(Long id);
}
