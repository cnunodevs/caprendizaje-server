package com.sena.caprendizaje.empleabilidad.service.adapter;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.PostulacionModel;
import com.sena.caprendizaje.empleabilidad.model.dto.VacanteModel;
import com.sena.caprendizaje.empleabilidad.service.port.PostulacionServiceProvider;

@Service
public class PostulacionServiceAdapter implements PostulacionServiceProvider {

    @Override
    public List<PostulacionModel> handleRetrievePostulaciones() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleRetrievePostulaciones'");
    }

    @Override
    public List<PostulacionModel> handleRetrievePostulacionesByExample(VacanteModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleRetrievePostulacionesByExample'");
    }

    @Override
    public Page<PostulacionModel> handleRetrievePostulacionesPaginated() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleRetrievePostulacionesPaginated'");
    }

    @Override
    public PostulacionModel handleCreatePostulacion(VacanteModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleCreatePostulacion'");
    }

    @Override
    public PostulacionModel handleUpdatePostulacion(VacanteModel model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleUpdatePostulacion'");
    }
    
}
