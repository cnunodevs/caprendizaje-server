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
@Table(name = "vacantes", schema = "public")
public class Vacante implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "salario")
    private Double salario;
    
    @ManyToOne
    @JoinColumn(name = "moneda")
    private Parametro moneda;

    @ManyToOne
    @JoinColumn(name = "empresa")
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "ciudad")
    private Parametro ciudad;

    @ManyToOne
    @JoinColumn(name = "modalidad")
    private Parametro modalidad;

    @ManyToOne
    @JoinColumn(name = "categoria")
    private Parametro categoria;

    @Column(name = "activo")
    private boolean activo;

    @Column(name = "fecha_creacion")
    @CreationTimestamp
    private LocalDateTime fechaCreacion;

    @Column(name = "ultima_actualizacion")
    @CreationTimestamp
    private LocalDateTime ultimaActualizacion;
    
    
}
