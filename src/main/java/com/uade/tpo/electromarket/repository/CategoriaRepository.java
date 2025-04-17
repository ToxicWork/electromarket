package com.uade.tpo.electromarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uade.tpo.electromarket.entity.Categoria;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria,Long>{

    @Query(value = "select c from Categoria c where c.nombre = ?1")
    List<Categoria> buscarPorNombre(String nombre);
}
