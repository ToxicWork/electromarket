package com.uade.tpo.electromarket.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uade.tpo.electromarket.entity.Categoria;
import com.uade.tpo.electromarket.entity.dto.CategoriaRequest;
import com.uade.tpo.electromarket.exceptions.CategoriaDuplicadaException;
import com.uade.tpo.electromarket.service.CategoriaService;
import com.uade.tpo.electromarket.service.CategoriaServiceImpl;

import java.util.List;
import java.util.Optional;
import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("categorias")

public class CategoriaController {
    
    @Autowired
    private CategoriaService categoriaService;

    
    @GetMapping()
    public ResponseEntity<List<Categoria>> getCategorias() {
        return ResponseEntity.ok(this.categoriaService.getCategorias());
    }
    
    @GetMapping("/{categoriaId}")
    public ResponseEntity<Categoria> getcategoriaPorId(@PathVariable long categoriaId) {
           Optional<Categoria> result = categoriaService.getCategoriaPorId(categoriaId);
        if (result.isPresent())
            return ResponseEntity.ok(result.get());

        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Object> agregarCategoria(@RequestBody CategoriaRequest categoriaRequest) throws CategoriaDuplicadaException {
                
        Categoria result = categoriaService.agregarCategoria(categoriaRequest.getNombre(), categoriaRequest.getDescripcion());
        return ResponseEntity.created(URI.create("/categorias/" + result.getId())).body(result);
    }
    
    
}
