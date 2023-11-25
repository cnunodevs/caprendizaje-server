package com.sena.caprendizaje.empleabilidad.service.adapter;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.PerfilModel;
import com.sena.caprendizaje.empleabilidad.model.mapper.PerfilMapper;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Perfil;
import com.sena.caprendizaje.empleabilidad.persistence.repository.port.PerfilesRepository;
import com.sena.caprendizaje.empleabilidad.service.port.PerfilesServiceProvider;
import com.sena.caprendizaje.shared.message.Message;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PerfilesServiceAdapter implements PerfilesServiceProvider {

    private final PerfilesRepository perfilesRepository;
    private final PerfilMapper perfilMapper;

    @Override
    public Page<PerfilModel> listarPerfiles(Pageable pageable) {
        Page<Perfil> perfiles = perfilesRepository.findAll(pageable);
        Page<PerfilModel> perfilModel = new PageImpl<>(
                perfiles.stream().map(perfilMapper::mapToModel).toList());
        return perfilModel;
    }

    @Override
    public PerfilModel crearPerfil(PerfilModel perfil) {
        return perfilMapper.mapToModel(perfilesRepository.save(perfilMapper.mapToEntity(perfil)));
    }

    @Override
    public PerfilModel obtenerPerfilPorId(Long id) {
        Optional<Perfil> optional = perfilesRepository.findById(id);
        if (optional.isPresent()) {
            return perfilMapper.mapToModel(optional.get());
        }
        throw new IllegalArgumentException(Message.Resources.Perfil.PERFIL_NOT_FOUND);
    }

    @Override
    public PerfilModel editarPerfilPorId(Long id, PerfilModel perfil) {
        Optional<Perfil> optional = perfilesRepository.findById(id);
        if (optional.isPresent()) {
            perfil.setId(id);
            return perfilMapper.mapToModel(perfilesRepository.save(perfilMapper.mapToEntity(perfil)));
        }
        throw new IllegalArgumentException(Message.Resources.Perfil.PERFIL_NOT_FOUND);
    }

    @Override
    public boolean eliminarPerfilPorId(Long id) {
        Optional<Perfil> optional = perfilesRepository.findById(id);
        if (optional.isPresent()) {
            perfilesRepository.delete(optional.get());
            return true;
        }
        return false;
    }

}
