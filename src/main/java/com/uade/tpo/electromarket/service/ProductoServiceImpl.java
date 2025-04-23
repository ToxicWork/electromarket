package com.uade.tpo.electromarket.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uade.tpo.electromarket.entity.Producto;
import com.uade.tpo.electromarket.exceptions.ProductoDuplicadoException;
import com.uade.tpo.electromarket.exceptions.ProductoNoExisteException;
import com.uade.tpo.electromarket.exceptions.ProductoSinStockException;
import com.uade.tpo.electromarket.repository.ProductoRepository;

@Service
public class ProductoServiceImpl implements ProductoService{
    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> getProductos() {
        
        return productoRepository.findAll();
    }
    
    
    public Optional<Producto> getProductoPorId(long productoId) throws ProductoSinStockException{

        List<Producto> productos = productoRepository.findById(productoId).map(List::of).orElse(Collections.emptyList());

        if(!productos.get(0).tieneStock()){
            throw new ProductoSinStockException();
        }
        
        return productoRepository.findById(productoId);
    
    }

    
    public Producto agregarProducto(String nombre, String descripcion) throws ProductoDuplicadoException {
        List<Producto> productos = productoRepository.buscarPorNombre(nombre);
        if (productos.isEmpty()) {
            return productoRepository.save(new Producto(nombre, descripcion));
        }
        
        throw new ProductoDuplicadoException();        
        
    }

    public Producto actualizarProducto(String nombre, long stock, float precio) throws ProductoNoExisteException{
        List<Producto> productos = productoRepository.buscarPorNombre(nombre);
        if (productos.isEmpty()) {
            throw new ProductoNoExisteException();
        }

        Producto productoActualizado = productos.get(0);

        productoActualizado.setStock(stock);
        productoActualizado.setPrecio(precio);

        return productoRepository.save(productoActualizado);
    }

    public void eliminarProducto(String nombre){

         List<Producto> productos = productoRepository.buscarPorNombre(nombre);
        
         productoRepository.delete(productos.get(0));

    };

}
