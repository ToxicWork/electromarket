package com.uade.tpo.electromarket.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uade.tpo.electromarket.entity.Pedido;
import com.uade.tpo.electromarket.entity.Producto;
import com.uade.tpo.electromarket.repository.PedidoRepository;

@Service
public class PedidoServiceImpl implements PedidoService{
    @Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> getPedidos() {
        
        return pedidoRepository.findAll();
    }

    public Optional<Pedido> getPedidoPorId(long pedidoId) {

        return pedidoRepository.findById(pedidoId);
    
    }
    
    public Pedido agregarPedido(List<Producto> productos) {
        
        Pedido nuevoPedido = new Pedido();
        //nuevoPedido.setProductos(productos);

        return pedidoRepository.save(nuevoPedido);
       
    }

    public Pedido actualizarPedido(List<Producto> productos, long pedidoId) {
        
        List<Pedido> pedidos = pedidoRepository.findById(pedidoId).map(List::of).orElse(Collections.emptyList());

        Pedido pedidoActualizado = pedidos.get(0);

        //pedidoActualizado.setProductos(productos);

        return pedidoRepository.save(pedidoActualizado);
       
    }

    public void eliminarPedido(long pedidoId){
        List<Pedido> pedidos = pedidoRepository.findById(pedidoId).map(List::of).orElse(Collections.emptyList());
        
        pedidoRepository.delete(pedidos.get(0));

    }
}
