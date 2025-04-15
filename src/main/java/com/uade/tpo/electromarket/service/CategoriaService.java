package com.uade.tpo.electromarket.service;

import java.util.List;
import java.util.Optional;

import com.uade.tpo.electromarket.entity.Categoria;
import com.uade.tpo.electromarket.exceptions.CategoriaDuplicadaException;

public interface CategoriaService {
    public List<Categoria> getCategorias();
    public Optional<Categoria> getCategoriaPorId(long categoriaId);
    public Categoria agregarCategoria(String nombre, String descripcion) throws CategoriaDuplicadaException;
}
