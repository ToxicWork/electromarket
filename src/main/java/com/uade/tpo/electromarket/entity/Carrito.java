package com.uade.tpo.electromarket.entity;

import com.uade.tpo.electromarket.enums.EstadoCarrito;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Carrito {

    private Long id;
    private Usuario usuario;
    private LocalDateTime fecha;
    private EstadoCarrito estado;
    private List<Item> items;

    public Carrito agregarItem(Item item){
        this.items.add(item);
        return this;
    }

    public Carrito removerItem(Item item){
        this.items.remove(item);
        return this;
    }

    public Carrito vaciarCarrito(){
        this.items.clear();
        return this;
    }
}
