package com.uade.tpo.electromarket.service;

import com.uade.tpo.electromarket.entity.Carrito;
import com.uade.tpo.electromarket.service.CarritoService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarritoServiceImpl implements CarritoService {

    private final List<Carrito> carritos = new ArrayList<>();

    @Override
    public List<Carrito> obtenerTodos() {
        return new ArrayList<>(carritos);
    }

    @Override
    public Optional<Carrito> obtenerPorId(Long id) {
        return carritos.stream().filter(c -> c.getId().equals(id)).findFirst();
    }

    @Override
    public Carrito crear(Carrito carrito) {
        carritos.add(carrito);
        return carrito;
    }

    @Override
    public void eliminar(Long id) {
        carritos.removeIf(c -> c.getId().equals(id));
    }
}
