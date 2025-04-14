package com.uade.tpo.electromarket.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
public class Categoria {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column
    private String nombre;

    @Column
    private String descripcion;

}
