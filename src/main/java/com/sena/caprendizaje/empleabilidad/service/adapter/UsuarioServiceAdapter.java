package com.sena.caprendizaje.empleabilidad.service.adapter;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.model.dto.UsuarioModel;
import com.sena.caprendizaje.empleabilidad.model.mapper.UsuarioMapper;
import com.sena.caprendizaje.empleabilidad.persistence.entity.Usuario;
import com.sena.caprendizaje.empleabilidad.persistence.repository.adapter.jpa.UsuariosRepository;
import com.sena.caprendizaje.empleabilidad.service.port.UsuarioServiceProvider;
import com.sena.caprendizaje.shared.message.Message;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceAdapter implements UsuarioServiceProvider {

    private final UsuariosRepository usuariosRepository;
    private final UsuarioMapper usuarioMapper;

    @Override
    public UsuarioModel obtenerUsuarioPorId(Long id) {
        Optional<Usuario> usuario = usuariosRepository.findById(id);
        if (usuario.isPresent()) {
            return usuarioMapper.mapToModel(usuario.get());
        }
        throw new IllegalArgumentException(Message.Resources.Usuario.USUARIO_NOT_FOUND);
    }

    @Override
    public UsuarioModel crearUsuario(UsuarioModel usuarioModel) {
        Usuario usuario = usuariosRepository.save(usuarioMapper.mapToEntity(usuarioModel));
        return usuarioMapper.mapToModel(usuario);
    }

    @Override
    public Page<UsuarioModel> listarUsuarios(Pageable pageable) {
        Page<Usuario> usuarios = usuariosRepository.findAll(pageable);
        Page<UsuarioModel> usuariosModel = new PageImpl<>(
                usuarios.stream().map(usuarioMapper::mapToModel).toList());
        return usuariosModel;
    }

    @Override
    public UsuarioModel editarUsuarioPorId(Long id, UsuarioModel usuarioModel) {
        Optional<Usuario> usuario = usuariosRepository.findById(id);
        if (usuario.isPresent()) {
            usuarioModel.setId(id);
            Usuario entity = usuariosRepository.save(usuarioMapper.mapToEntity(usuarioModel));
            return usuarioMapper.mapToModel(entity);
        }
         throw new IllegalArgumentException(Message.Resources.Usuario.USUARIO_NOT_FOUND);
    }

    @Override
    public boolean eliminarUsuarioPorId(Long id) {
        Optional<Usuario> usuario = usuariosRepository.findById(id);
        if (usuario.isPresent()) {
            usuariosRepository.delete(usuario.get());
            return true;
        }
        return false;
    }


    @Override
    public Optional<Usuario> handleFindByUsuario(String usuario) {
        return usuariosRepository.findFirstByUsuario(usuario);
    }


}
