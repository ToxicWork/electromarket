package com.uade.tpo.electromarket.service;

import java.util.ArrayList;
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

    
   // public Categoria agregarCategoria(int id, String nombre, String descripcion) throws CategoriaDuplicadaException{
   //     ArrayList<Categoria> categorias = categoriaRepository.getCategorias();
   //     if (categorias.stream().anyMatch(
   //             categoria -> categoria.getId() ==   id && 
   //                                                 categoria.getNombre().equals(nombre) &&
   //                                                 categoria.getDescripcion().equals(descripcion) ))
   //         throw new CategoriaDuplicadaException();
   //     return categoriaRepository.agregarCategoria(id, nombre, descripcion);
   // }
}
