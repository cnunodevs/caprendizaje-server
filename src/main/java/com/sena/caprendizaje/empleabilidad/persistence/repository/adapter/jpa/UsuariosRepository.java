package com.sena.caprendizaje.empleabilidad.persistence.repository.adapter.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sena.caprendizaje.empleabilidad.persistence.entity.Usuario;

public interface UsuariosRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findFirstByUsuario(String usuario);

    @Query(value="select count(u.id) from usuarios u inner join perfiles p on u.id_perfil = p.id where u.usuario = :usuario and p.activo and u.activo " , nativeQuery = true)
    Integer validateUserAndProfile(String usuario);

}
