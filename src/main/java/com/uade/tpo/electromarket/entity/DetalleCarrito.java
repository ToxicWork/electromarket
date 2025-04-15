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
    
    public DetalleCarrito(long pedidoId,Producto producto,int cantidad,float precio){
        this.pedidoId = pedidoId;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio   = precio;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private long pedidoId;

    @Column
    private Producto producto;

    @Column
    private int cantidad;

    @Column 
    private float precio;
    
}
