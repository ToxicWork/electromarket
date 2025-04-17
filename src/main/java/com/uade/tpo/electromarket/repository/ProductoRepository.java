package com.uade.tpo.electromarket.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uade.tpo.electromarket.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long>{
    
    @Query(value = "select p from Producto p where p.nombre = ?1")
    List<Producto> findByNombre(String nombre);
}
