package com.uade.tpo.electromarket.service;

import com.uade.tpo.electromarket.entity.Carrito;
import com.uade.tpo.electromarket.repository.CarritoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoServiceImpl implements CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    @Override
    public List<Carrito> obtenerCarritos() {
        return carritoRepository.findAll();
    }

    @Override
    public Optional<Carrito> obtenerCarritoPorId(Long carritoId) {
        return carritoRepository.findById(carritoId);
    }

    @Override
    public Carrito crearCarrito(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    @Override
    public Carrito actualizarCarrito(Carrito carrito) {
        return carritoRepository.save(carrito);
    }

    @Override
    public void eliminarCarrito(Long carritoId) {
        carritoRepository.deleteById(carritoId);
    }
}