package com.sena.caprendizaje.empleabilidad.persistence.entity;

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
@Table(name = "postulaciones", schema = "public")
public class Postulacion implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "postulacion")
    private Postulacion postulacion;

    @ManyToOne
    @JoinColumn(name = "vacante")
    private Vacante vacante;

    @Column(name = "estado")
    private Parametro estado;

    @Column(name = "activa")
    private Boolean activa;
    
}
