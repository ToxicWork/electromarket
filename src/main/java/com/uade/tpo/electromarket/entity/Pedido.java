package com.uade.tpo.electromarket.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long count;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "producto")
    private List<Producto> productos;

    private Cupon cupon;

    public float getTotal(){

        float resultado = 0;

        for(int i = 0; i < this.productos.size() ; i++){
            resultado = resultado + this.productos.get(i).getPrecio();
        }

        resultado = resultado + this.cupon.getValor();
        return resultado;
    }

    public float getSubtotal(){
        
        float resultado = 0;

        for(int i = 0; i < this.productos.size() ; i++){
            resultado = resultado + this.productos.get(i).getPrecio();
        }

        return resultado;
    }
}
