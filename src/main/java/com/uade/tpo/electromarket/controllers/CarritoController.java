package com.uade.tpo.electromarket.controllers;

import com.uade.tpo.electromarket.entity.Carrito;
import com.uade.tpo.electromarket.service.CarritoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("carritos")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    @GetMapping
    public ResponseEntity<List<Carrito>> obtenerCarritos() {
        return ResponseEntity.ok(carritoService.obtenerCarritos());
    }

    @GetMapping("/{carritoId}")
    public ResponseEntity<Carrito> obtenerCarritoPorId(@PathVariable Long carritoId) {
        Optional<Carrito> carrito = carritoService.obtenerCarritoPorId(carritoId);
        return carrito.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Carrito> crearCarrito(@RequestBody Carrito carrito) {
        Carrito nuevoCarrito = carritoService.crearCarrito(carrito);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCarrito);
    }

    @PutMapping("/{carritoId}")
    public ResponseEntity<Carrito> actualizarCarrito(@PathVariable Long carritoId, @RequestBody Carrito carrito) {
        carrito.setId(carritoId);
        Carrito carritoActualizado = carritoService.actualizarCarrito(carrito);
        return ResponseEntity.ok(carritoActualizado);
    }

    @DeleteMapping("/{carritoId}")
    public ResponseEntity<Void> eliminarCarrito(@PathVariable Long carritoId) {
        carritoService.eliminarCarrito(carritoId);
        return ResponseEntity.noContent().build();
    }
}
