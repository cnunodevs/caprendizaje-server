package com.sena.caprendizaje.empleabilidad.service.adapter;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.DataPersonalModel;
import com.sena.caprendizaje.empleabilidad.model.mapper.DataPersonalMapper;
import com.sena.caprendizaje.empleabilidad.persistence.entity.DataPersonal;
import com.sena.caprendizaje.empleabilidad.persistence.repository.adapter.jpa.DataPersonalRepository;
import com.sena.caprendizaje.empleabilidad.service.port.DataPersonalServiceProvider;
import com.sena.caprendizaje.shared.message.Message;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DataPersonalServiceAdapter implements DataPersonalServiceProvider {

    private final DataPersonalRepository dataPersonalRepository;
    private final DataPersonalMapper dataPersonalMapper;

    @Override
    public DataPersonalModel obtenerDataPersonalPorId(Long id) {
        Optional<DataPersonal> optional = dataPersonalRepository.findById(id);
        if (optional.isPresent()) {
            return dataPersonalMapper.mapToModel(optional.get());
        }
        throw new IllegalArgumentException(Message.Resources.DataPersonal.DATA_PERSONAL_NOT_FOUND);
    }

    @Override
    public DataPersonalModel crearDataPersonal(DataPersonalModel dataPersonalModel) {
        DataPersonal dataPersonal = dataPersonalRepository.save(dataPersonalMapper.mapToEntity(dataPersonalModel));
        return dataPersonalMapper.mapToModel(dataPersonal);
    }

    @Override
    public Page<DataPersonalModel> listarDataPersonal(Pageable pageable) {
        Page<DataPersonal> listaDataPersonal = dataPersonalRepository.findAll(pageable);
        Page<DataPersonalModel> listaDataPersonalModel = new PageImpl<>(
                listaDataPersonal.stream().map(dataPersonalMapper::mapToModel).toList());
        return listaDataPersonalModel;
    }

    @Override
    public DataPersonalModel editarDataPersonal(Long id, DataPersonalModel dataPersonalModel) {
        Optional<DataPersonal> optional = dataPersonalRepository.findById(id);
        if (optional.isPresent()) {
            dataPersonalModel.setId(id);
            DataPersonal dataPersonal = dataPersonalRepository.save(dataPersonalMapper.mapToEntity(dataPersonalModel));
            return dataPersonalMapper.mapToModel(dataPersonal);
        }
        throw new IllegalArgumentException(Message.Resources.DataPersonal.DATA_PERSONAL_NOT_FOUND);
    }

    @Override
    public boolean eliminarDataPersonalPorId(Long id) {
        Optional<DataPersonal> optional = dataPersonalRepository.findById(id);
        if (optional.isPresent()) {
            dataPersonalRepository.delete(optional.get());
            return true;
        }
        return false;
    }

}
