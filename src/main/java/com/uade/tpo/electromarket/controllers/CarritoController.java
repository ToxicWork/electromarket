package com.uade.tpo.electromarket.controllers;

import com.uade.tpo.electromarket.entity.Carrito;
import com.uade.tpo.electromarket.entity.Pedido;
import com.uade.tpo.electromarket.entity.Item;
import com.uade.tpo.electromarket.service.CarritoService;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/carrito")
@RequiredArgsConstructor

public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    //@GetMapping
    //public List<Carrito> obtenerTodos() {
    //    return carritoService.obtenerTodos();
    //}

    //@GetMapping("/{id}")
    //public Carrito obtenerPorId(@PathVariable Long id) {
    //    return carritoService.obtenerPorId(id)
    //            .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
    //}

    //@PostMapping
    //public Carrito crear(@RequestBody Carrito carrito) {
    //    return carritoService.crear(carrito);
    //}

    //@DeleteMapping("/{id}")
    //public void eliminar(@PathVariable Long id) {
    //carritoService.eliminar(id);
    //}

    @PostMapping
    public Carrito agregarItem(@RequestBody Carrito carrito, Item item) {
                
        return carritoService.agregarItem(carrito,item);
    }

    @PostMapping("/{productoId}")
    public Carrito removerItem(@RequestBody Carrito carrito,Item item) {
                
        return carritoService.removerItem(carrito,item);
    }

    @PostMapping("/vaciar")
    public Carrito vaciarCarrito(@RequestBody Carrito carrito) {
                
        return carritoService.vaciarCarrito(carrito);
    }

    @PostMapping("/comprar")
    public ResponseEntity<Object> comprarCarrito(@RequestBody Carrito carrito) {
                
        return carritoService.comprarCarrito(carrito);
    }
    
    
}
