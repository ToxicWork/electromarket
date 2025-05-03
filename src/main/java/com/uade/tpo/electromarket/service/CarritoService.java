package com.uade.tpo.electromarket.service;

import com.uade.tpo.electromarket.entity.Carrito;
import com.uade.tpo.electromarket.entity.Pedido;
import com.uade.tpo.electromarket.entity.Item;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;


public interface CarritoService {
    //public List<Carrito> obtenerTodos();
    //public Optional<Carrito> obtenerPorId(Long id);
    //public Carrito crear(Carrito carrito);
    //public void eliminar(Long id);
    public Carrito agregarItem(Carrito carrito, Item item);
    public Carrito removerItem(Carrito carrito, Item item);
    public Carrito vaciarCarrito(Carrito carrito);
    public ResponseEntity<Object> comprarCarrito(Carrito carrito);
}
