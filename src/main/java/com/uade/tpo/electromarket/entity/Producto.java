package com.uade.tpo.electromarket.entity;

import java.util.Locale.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Producto {

    public Producto(String nombre, String descripcion){
        this.nombre         = nombre;
        this.descripcion    = descripcion;
        this.stock          = 0;
        this.precio         = 0;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column
    private String nombre;

    @Column
    private String descripcion;

    @Column
    private long stock;

    @Column
    private float precio;

    @OneToOne
    @JoinColumn(name = "categoria_id", referencedColumnName = "id")
    private Categoria categoria;
}
