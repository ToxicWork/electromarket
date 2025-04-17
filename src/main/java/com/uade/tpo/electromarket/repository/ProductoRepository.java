package com.uade.tpo.electromarket.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uade.tpo.electromarket.entity.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long>{
    
}
