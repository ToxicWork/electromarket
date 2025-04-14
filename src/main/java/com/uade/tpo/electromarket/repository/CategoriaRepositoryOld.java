package com.uade.tpo.electromarket.repository;

import com.uade.tpo.electromarket.entity.Categoria;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

public class CategoriaRepositoryOld {
    
    private ArrayList<Categoria> categorias;


    public CategoriaRepositoryOld() {
        this.categorias = new ArrayList<Categoria>(
            Arrays.asList(Categoria.builder().id(1).descripcion("Computadoras").nombre("Computadoras").build())
            //Acá hay que actualizar con la parte que conecta a la Base de Datos
        );
    }

    public ArrayList<Categoria> getCategorias(){

        return this.categorias;
    }

    public Optional<Categoria> getCategoriaPorId(int categoriaId){
        return this.categorias.stream().filter(m -> m.getId() == categoriaId).findAny();
    }

    public Categoria agregarCategoria(int id, String nombre, String descripcion){
        
        Categoria nuevaCategoria = Categoria.builder()
                .id(id)
                .nombre(nombre)
                .descripcion(descripcion)
                .build()
                ;
        
        this.categorias.add(nuevaCategoria);
        return nuevaCategoria;
    }
}
