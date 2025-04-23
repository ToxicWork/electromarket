package com.uade.tpo.electromarket.entity.dto;

import java.util.List;

import com.uade.tpo.electromarket.entity.Cupon;
import com.uade.tpo.electromarket.entity.Producto;

import lombok.Data;

@Data
public class PedidoRequest {
    private Long id;
    private List<Producto> productos;
    private Cupon cupon;
}
