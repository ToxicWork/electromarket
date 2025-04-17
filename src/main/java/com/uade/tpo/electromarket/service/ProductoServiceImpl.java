package com.uade.tpo.electromarket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uade.tpo.electromarket.entity.Producto;
import com.uade.tpo.electromarket.exceptions.ProductoDuplicadoException;
import com.uade.tpo.electromarket.exceptions.ProductoNoExisteException;
import com.uade.tpo.electromarket.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getProductos() {
        
        return productoRepository.findAll();
    }
    
    
    public Optional<Producto> getProductoPorId(long productoId) {
        
        return productoRepository.findById(productoId);
    }

    
   public Producto agregarProducto(String nombre, String descripcion) throws ProductoDuplicadoException{
        List<Producto> productos = productoRepository.findAll();
        if (productos.stream().anyMatch(
                producto -> producto.getNombre().equals(nombre) ))
            throw new ProductoDuplicadoException();
        return productoRepository.save(new Producto(nombre, descripcion));
    }

    public Producto agregarStock(String nombre, long stock) throws ProductoNoExisteException{
        List<Producto> productos = productoRepository.findAll();
        if (! productos.stream().anyMatch(
                producto -> producto.getNombre().equals(nombre) ))
            throw new ProductoNoExisteException();
        Producto producto = productos.getFirst();
        producto.setStock(producto.getStock() + stock);

        return productoRepository.save(producto);
    }

    public Producto modificarPrecio(String nombre, float precio) throws ProductoNoExisteException{
        List<Producto> productos = productoRepository.findAll();
        if (! productos.stream().anyMatch(
                producto -> producto.getNombre().equals(nombre) ))
            throw new ProductoNoExisteException();
        Producto producto = productos.getFirst();
        producto.setPrecio(precio);

        return productoRepository.save(producto);
    }
}
