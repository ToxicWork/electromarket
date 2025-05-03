package com.uade.tpo.electromarket.service;

import java.util.List;
import java.util.Optional;

import com.uade.tpo.electromarket.entity.Pedido;
import com.uade.tpo.electromarket.entity.Item;


public interface PedidoService {
    public List<Pedido> getPedidos();
    public Optional<Pedido> getPedidoPorId(long pedidoId);
    public Pedido agregarPedido(List<Item> pedidoItems);
    //public Pedido actualizarPedido(List<Producto> productos, long pedidoId);
    public void eliminarPedido(long pedidoId);

    //agregado post primera entrega
    //public Pedido confirmarPedido(UserDetails user);
    //public List<Pedido> obtenerPedidosUsuario(String email);

}
