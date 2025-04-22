package com.uade.tpo.electromarket.controllers;

import com.uade.tpo.electromarket.entity.Carrito;
import com.uade.tpo.electromarket.service.CarritoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carritos")
@RequiredArgsConstructor
public class CarritoController {

    private final CarritoService carritoService;

    @GetMapping
    public List<Carrito> obtenerTodos() {
        return carritoService.obtenerTodos();
    }

    @GetMapping("/{id}")
    public Carrito obtenerPorId(@PathVariable Long id) {
        return carritoService.obtenerPorId(id)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
    }

    @PostMapping
    public Carrito crear(@RequestBody Carrito carrito) {
        return carritoService.crear(carrito);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        carritoService.eliminar(id);
    }
}
