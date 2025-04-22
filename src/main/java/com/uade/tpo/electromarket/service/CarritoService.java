package com.uade.tpo.electromarket.service;

import com.uade.tpo.electromarket.entity.Carrito;

import java.util.List;
import java.util.Optional;

public interface CarritoService {
    List<Carrito> obtenerTodos();
    Optional<Carrito> obtenerPorId(Long id);
    Carrito crear(Carrito carrito);
    void eliminar(Long id);
}
