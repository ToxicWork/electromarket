package com.uade.tpo.electromarket.entity.dto;

import lombok.Data;

@Data
public class ProductoRequest {
    
    private int id;
    private String nombre;
    private String descripcion;
    private long stock;
    private float precio;

}
