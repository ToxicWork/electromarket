package com.uade.tpo.electromarket.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.uade.tpo.electromarket.entity.Pedido;
import com.uade.tpo.electromarket.entity.dto.PedidoRequest;
import com.uade.tpo.electromarket.service.PedidoService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("pedidos")

public class PedidoController {
    @Autowired
    private PedidoService pedidoService;

    @GetMapping()
    public ResponseEntity<List<Pedido>> getPedidos() {
        return ResponseEntity.ok(this.pedidoService.getPedidos());
    }

    @GetMapping("/{pedidoId}")
    public ResponseEntity<Pedido> getPedidoPorId(@PathVariable long pedidoId) {
           Optional<Pedido> result = pedidoService.getPedidoPorId(pedidoId);
        if (result.isPresent())
            return ResponseEntity.ok(result.get());

        return ResponseEntity.noContent().build();
    }   

    @PostMapping
    public ResponseEntity<Object> agregarPedido(@RequestBody PedidoRequest pedidoRequest) {
                
        Pedido result = pedidoService.agregarPedido(pedidoRequest.getProductos());
        return ResponseEntity.created(URI.create("/pedidos/" + result.getId())).body(result);
    }

    @PutMapping
    public ResponseEntity<Object> actualizarPedido(@RequestBody PedidoRequest pedidoRequest) {
       
        pedidoService.actualizarPedido(pedidoRequest.getProductos(),pedidoRequest.getId());
       
       return ResponseEntity.ok(pedidoRequest);
    }

    @DeleteMapping
    public void eliminarPedido(@RequestBody PedidoRequest pedidoRequest){

        pedidoService.eliminarPedido(pedidoRequest.getId());

    }
}
