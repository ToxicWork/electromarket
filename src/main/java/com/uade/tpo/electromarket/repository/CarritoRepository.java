package com.uade.tpo.electromarket.repository;

import com.uade.tpo.electromarket.entity.Carrito;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {
}