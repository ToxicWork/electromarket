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
public class ProductoServiceImpl {
     @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getCategorias() {
        
        return productoRepository.findAll();
    }
    
    
    public Optional<Producto> getCategoriaPorId(long productoId) {
        
        return productoRepository.findById(productoId);
    }

    
   public Producto agregarProducto(String nombre, String descripcion) throws ProductoDuplicadoException{
        List<Producto> productos = productoRepository.findAll();
        if (productos.stream().anyMatch(
                producto -> producto.getNombre().equals(nombre) ))
            throw new ProductoDuplicadoException();
        return productoRepository.save(new Producto(nombre, descripcion));
    }

    public Producto agregarStock(String nombre, Long stock) throws ProductoNoExisteException{
        List<Producto> productos = productoRepository.findAll();
        if (! productos.stream().anyMatch(
                producto -> producto.getNombre().equals(nombre) ))
            throw new ProductoNoExisteException();
        Producto producto = productos.getFirst();
        producto.setStock(stock);

        return productoRepository.save(producto);
    }
}
