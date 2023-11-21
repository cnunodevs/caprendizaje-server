package com.sena.caprendizaje.empleabilidad.persistence.repository.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.PostulacionFilter;
import com.sena.caprendizaje.empleabilidad.model.dto.PostulacionModel;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Postulacion;
import com.sena.caprendizaje.empleabilidad.persistence.repository.adapter.jpa.PostulacionesRepositoryJpa;
import com.sena.caprendizaje.empleabilidad.persistence.repository.port.PostulacionesRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostulacionesRepositoryAdapter implements PostulacionesRepository {

    private final JdbcTemplate jdbcTemplate;
    private final PostulacionesRepositoryJpa repositoryJpa;

    @Override
    public Boolean handleAlreadyPostulado(Long vacante, Long postulante) {
        final String sql = "select exists(select 1 from postulaciones where vacante = ? and postulante = ?)";
        return jdbcTemplate.queryForObject(sql, Boolean.class, vacante, postulante);
    }

    @Override
    public List<Postulacion> handleRetrievePostulaciones() {
        return repositoryJpa.findAll();
    }

    @Override
    public List<Postulacion> handleRetrievePostulacionesByExample(Postulacion model) {
        Example<Postulacion> example = Example.of(model);
        return repositoryJpa.findAll(example);
    }

    @Override
    public Optional<Postulacion> handleFindPostulacionById(Long id) {
        return repositoryJpa.findById(id);
    }

    @Override
    public Boolean handleAlreadyExists(Postulacion model) {
        return repositoryJpa.existsById(model.getId());
    }

    @Override
    public Page<Postulacion> handleRetrievePostulacionesPaginated() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleRetrievePostulacionesPaginated'");
    }

    @Override
    public Postulacion handleCreatePostulacion(Postulacion model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleCreatePostulacion'");
    }

    @Override
    public Postulacion handleUpdatePostulacion(Postulacion model) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleUpdatePostulacion'");
    }

    @Override
    public PostulacionModel handleRetrievePostulacionFiltered(PostulacionFilter filter) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'handleRetrievePostulacionFiltered'");
    }
    
}
