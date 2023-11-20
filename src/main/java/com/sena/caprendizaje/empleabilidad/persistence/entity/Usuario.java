package com.sena.caprendizaje.empleabilidad.persistence.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import com.sena.caprendizaje.shared.model.entity.GenericEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Builder
@AllArgsConstructor @NoArgsConstructor
@Table(name = "usuarios", schema = "public")
public class Usuario implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "datos_personal")
    private DataPersonal datosPersonales;

    @Column(name = "usuario")
    private String usuario;

    @Column(name = "contrasena")
    private String contraseña;

    @ManyToOne
    @JoinColumn(name = "perfil")
    private Perfil perfil;

    @Column(name = "activo")
    private boolean activo;

    @Column(name = "fecha_creacion")
    @CreationTimestamp
    private LocalDateTime fechaCreacion;

}
