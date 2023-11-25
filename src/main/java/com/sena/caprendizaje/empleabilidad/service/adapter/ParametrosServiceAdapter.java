package com.sena.caprendizaje.empleabilidad.service.adapter;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.MaestroParametroModel;
import com.sena.caprendizaje.empleabilidad.model.dto.ParametroModel;
import com.sena.caprendizaje.empleabilidad.model.mapper.MaestroParametroMapper;
import com.sena.caprendizaje.empleabilidad.model.mapper.ParametroMapper;
import com.sena.caprendizaje.empleabilidad.persistence.entity.MaestroParametro;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Parametro;
import com.sena.caprendizaje.empleabilidad.persistence.repository.adapter.jpa.MaestroParametrosRepository;
import com.sena.caprendizaje.empleabilidad.persistence.repository.adapter.jpa.ParametrosRepository;
import com.sena.caprendizaje.empleabilidad.service.port.ParametrosServiceProvider;
import com.sena.caprendizaje.shared.message.Message;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ParametrosServiceAdapter implements ParametrosServiceProvider {

    private final MaestroParametrosRepository maestroParametrosRepository;
    private final ParametrosRepository parametrosRepository;
    private final ParametroMapper parametroMapper;
    private final MaestroParametroMapper maestroParametroMapper;

    @Override
    public List<ParametroModel> handleRetrieveParametrosByMaestro(Long id) {
        List<Parametro> parametros = parametrosRepository.findByMaestroParametroId(id);
        if (!parametros.isEmpty()) {
            List<ParametroModel> parametrosModel = parametros.stream().map(parametroMapper::mapToModel).toList();
            return parametrosModel;
        }
        throw new IllegalArgumentException(Message.Resources.Parametro.PARAMETRO_IS_EMPTY_BY_MAESTRO);
    }

    @Override
    public List<MaestroParametroModel> handleRetrieveMaestros() {
        return maestroParametrosRepository.findAll().stream()
                .map(maestroParametroMapper::mapToModel).toList();
    }

    @Override
    public ParametroModel handleCreateParametro(ParametroModel model) {
        return parametroMapper.mapToModel(parametrosRepository.save(parametroMapper.mapToEntity(model)));
    }

    @Override
    public ParametroModel handleUpdateParametro(ParametroModel model) {
        Optional<Parametro> optional = parametrosRepository.findById(model.getId());
        if (optional.isPresent()) {
            return parametroMapper.mapToModel(optional.get());
        }
        throw new IllegalArgumentException(Message.Resources.Parametro.PARAMETRO_NOT_FOUND);
    }

    @Override
    public MaestroParametroModel handleCreateMaestroParametro(MaestroParametroModel model) {
        return maestroParametroMapper
                .mapToModel(maestroParametrosRepository.save(maestroParametroMapper.mapToEntity(model)));
    }

    @Override
    public MaestroParametroModel handleUpdateMaestroParametro(MaestroParametroModel model) {
        Optional<MaestroParametro> optional = maestroParametrosRepository.findById(model.getId());
        if (optional.isPresent()) {
            return maestroParametroMapper.mapToModel(optional.get());
        }
        throw new IllegalArgumentException(Message.Resources.MaestroParametro.MAESTRO_PARAMETRO_NOT_FOUND);
    }

}
