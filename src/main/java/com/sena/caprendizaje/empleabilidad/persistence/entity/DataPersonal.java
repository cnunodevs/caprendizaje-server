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
@Table(name = "datos_personales", schema = "public")
public class DataPersonal implements GenericEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "telefono")
    private String telefono;

    @Column(name = "documento")
    private String documento;

    @ManyToOne
    @JoinColumn(name = "profesion")
    private Parametro profesion;

    @ManyToOne
    @JoinColumn(name = "tipo_documento")
    private Parametro tipoDocumento;

    private String curriculum;

    
}