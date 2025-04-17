package com.uade.tpo.electromarket.service;

import java.util.List;
import java.util.Optional;

import com.uade.tpo.electromarket.entity.Producto;
import com.uade.tpo.electromarket.exceptions.ProductoDuplicadoException;
import com.uade.tpo.electromarket.exceptions.ProductoNoExisteException;


public interface ProductoService {
    public List<Producto> getProductos();
    public Optional<Producto> getProductoPorId(long productoId);
    public Producto agregarProducto(String nombre, String descripcion) throws ProductoDuplicadoException;
    public Producto actualizarProducto(String nombre, long stock, float precio) throws ProductoNoExisteException;
}


