package com.uade.tpo.electromarket.entity;

import com.uade.tpo.electromarket.enums.EstadoCarrito;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Carrito {

    private Long id;
    private Usuario usuario;
    private LocalDateTime fecha;
    private EstadoCarrito estado;
}
