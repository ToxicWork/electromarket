package com.uade.tpo.electromarket.service;

import com.uade.tpo.electromarket.entity.Carrito;
import java.util.List;
import java.util.Optional;

public interface CarritoService {
    List<Carrito> obtenerCarritos();
    Optional<Carrito> obtenerCarritoPorId(Long carritoId);
    Carrito crearCarrito(Carrito carrito);
    Carrito actualizarCarrito(Carrito carrito);
    void eliminarCarrito(Long carritoId);
}
