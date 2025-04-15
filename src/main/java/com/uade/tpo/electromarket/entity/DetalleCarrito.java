package com.uade.tpo.electromarket.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class DetalleCarrito {
    
    public DetalleCarrito(){


    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long pedidoId;

    @Column
    private Pedido pedido;

    @Column
    private int cantidad;

    @Column 
    private float precio;
    
}
