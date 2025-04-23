package com.uade.tpo.electromarket.service;

import java.util.List;
import java.util.Optional;


import com.uade.tpo.electromarket.entity.Pedido;
import com.uade.tpo.electromarket.entity.Producto;


public interface PedidoService {
    public List<Pedido> getPedidos();
    public Optional<Pedido> getPedidoPorId(long pedidoId);
    public Pedido agregarPedido(List<Producto> productos);
    public Pedido actualizarPedido(List<Producto> productos, long pedidoId);
    public void eliminarPedido(long pedidoId);

}
