package com.uade.tpo.electromarket.service;

import com.uade.tpo.electromarket.controllers.CarritoController;
import com.uade.tpo.electromarket.controllers.PedidoController;
import com.uade.tpo.electromarket.entity.Carrito;
import com.uade.tpo.electromarket.entity.Pedido;
import com.uade.tpo.electromarket.entity.Item;
import com.uade.tpo.electromarket.entity.dto.PedidoRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarritoServiceImpl implements CarritoService {

    //private final List<Carrito> carritos = new ArrayList<>();
  
    //@Override
    //public List<Carrito> obtenerTodos() {
    //    return new ArrayList<>(carritos);
    //}

    //@Override
    //public Optional<Carrito> obtenerPorId(Long id) {
    //    return carritos.stream().filter(c -> c.getId().equals(id)).findFirst();
    //}

    //@Override
    //public Carrito crear(Carrito carrito) {
    //    carritos.add(carrito);
    //    return carrito;
    //}

    //@Override
    //public void eliminar(Long id) {
    //    carritos.removeIf(c -> c.getId().equals(id));
    //}

    public Carrito agregarItem(Carrito carrito, Item item){
        carrito.agregarItem(item);
        return carrito;
    }

    public Carrito removerItem(Carrito carrito, Item item){
        carrito.removerItem(item);
        return carrito;
    }

    public Carrito vaciarCarrito(Carrito carrito){
        return carrito.vaciarCarrito();
    }

    public ResponseEntity<Object> comprarCarrito(Carrito carrito) {
        PedidoRequest pedidoRequest = new PedidoRequest();
        
        pedidoRequest.setPedidoItems(carrito.getItems());
        
        PedidoController pedidoController = new PedidoController();
       
        return pedidoController.agregarPedido(pedidoRequest);
    }
}
