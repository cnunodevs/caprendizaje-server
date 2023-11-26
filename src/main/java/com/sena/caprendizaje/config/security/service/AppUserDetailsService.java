package com.sena.caprendizaje.config.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sena.caprendizaje.empleabilidad.persistence.entity.Usuario;
import com.sena.caprendizaje.empleabilidad.persistence.repository.adapter.jpa.UsuariosRepository;

import lombok.RequiredArgsConstructor;

@Service
@Primary
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final UsuariosRepository usuariosRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<GrantedAuthority> authorities = new ArrayList<>();
        Optional<Usuario> findFirstByUsuario = usuariosRepository.findFirstByUsuario(username);
        if (findFirstByUsuario.isEmpty()) {
            throw new UsernameNotFoundException("User details not found: " + username);
        }
        Usuario usuario = findFirstByUsuario.get();
        authorities.add(new SimpleGrantedAuthority(usuario.getPerfil().getCodigo()));
        return new User(usuario.getUsuario(), usuario.getContraseña(), authorities);
    }


    public boolean validateUserAndProfile(String username) {
        Integer usuarios = usuariosRepository.validateUserAndProfile(username);
       return usuarios > 0;
    }

}
