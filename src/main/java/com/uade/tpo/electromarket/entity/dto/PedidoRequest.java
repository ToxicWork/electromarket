package com.uade.tpo.electromarket.entity.dto;

import java.util.List;

import com.uade.tpo.electromarket.entity.Cupon;
import com.uade.tpo.electromarket.entity.Item;

import lombok.Data;

@Data
public class PedidoRequest {
    private Long id;
    private List<Item> pedidoItems;
    private Cupon cupon;
}
