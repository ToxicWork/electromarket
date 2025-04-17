package com.uade.tpo.electromarket.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.uade.tpo.electromarket.entity.Producto;
import com.uade.tpo.electromarket.entity.dto.ProductoRequest;
import com.uade.tpo.electromarket.exceptions.ProductoDuplicadoException;
import com.uade.tpo.electromarket.exceptions.ProductoNoExisteException;
import com.uade.tpo.electromarket.service.ProductoService;
import com.uade.tpo.electromarket.service.ProductoServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("productos")


public class ProductoController {
    
    @Autowired
    private ProductoService productoService;

    
    @GetMapping()
    public ResponseEntity<List<Producto>> getProductos() {
        return ResponseEntity.ok(this.productoService.getProductos());
    }
    
    @GetMapping("/{productoId}")
    public ResponseEntity<Producto> getProductoPorId(@PathVariable long productoId) {
        Optional<Producto> result = productoService.getProductoPorId(productoId);
        if (result.isPresent())
            return ResponseEntity.ok(result.get());

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Object> agregarProducto(@RequestBody ProductoRequest productoRequest) throws ProductoDuplicadoException {
        ProductoServiceImpl productoService = new ProductoServiceImpl();
        
        Producto result = productoService.agregarProducto(productoRequest.getNombre(), productoRequest.getDescripcion());
        return ResponseEntity.created(URI.create("/productos/" + result.getId())).body(result);
    }

    @PutMapping("/{productoId}")
    public ResponseEntity<Object> agregarStock(@RequestBody ProductoRequest productoRequest) throws ProductoNoExisteException {
        ProductoServiceImpl productoService = new ProductoServiceImpl();
        Producto result = productoService.agregarStock(productoRequest.getNombre(), productoRequest.getStock());
        return ResponseEntity.ok(result);
    }
 
    @PutMapping("/{productoId}")
    public ResponseEntity<Object> modificarPrecio(@RequestBody ProductoRequest productoRequest) throws ProductoNoExisteException {
        ProductoServiceImpl productoService = new ProductoServiceImpl();
        Producto result = productoService.modificarPrecio(productoRequest.getNombre(), productoRequest.getPrecio());
        return ResponseEntity.ok(result);
    }

}
