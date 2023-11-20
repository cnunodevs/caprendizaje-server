package com.sena.caprendizaje.empleabilidad.persistence.entity;

import com.sena.caprendizaje.shared.model.entity.GenericEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor @NoArgsConstructor
@Table(name = "empresas", schema = "public")
public class Empresa implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "codigo")
    private String codigo;

    @OneToOne
    @JoinColumn(name = "administrador")
    private Usuario administrador;

    @ManyToOne
    @JoinColumn(name = "foto_perfil")
    private Archivo fotoPerfil;
    
}
