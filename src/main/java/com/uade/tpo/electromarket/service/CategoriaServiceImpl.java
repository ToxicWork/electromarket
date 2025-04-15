package com.uade.tpo.electromarket.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uade.tpo.electromarket.entity.Categoria;
import com.uade.tpo.electromarket.exceptions.CategoriaDuplicadaException;
import com.uade.tpo.electromarket.repository.CategoriaRepository;


@Service
public class CategoriaServiceImpl implements CategoriaService {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    

    public List<Categoria> getCategorias() {
        
        return categoriaRepository.findAll();
    }
    
    
    public Optional<Categoria> getCategoriaPorId(long categoriaId) {
        
        return categoriaRepository.findById(categoriaId);
    }

    
   public Categoria agregarCategoria(String nombre, String descripcion) throws CategoriaDuplicadaException{
        List<Categoria> categorias = categoriaRepository.findAll();
        if (categorias.stream().anyMatch(
                categoria -> categoria.getNombre().equals(nombre) ))
            throw new CategoriaDuplicadaException();
        return categoriaRepository.save(new Categoria(nombre, descripcion));
    }
}
