package com.uade.tpo.electromarket.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uade.tpo.electromarket.entity.Usuario;
import com.uade.tpo.electromarket.entity.dto.UsuarioRequest;
import com.uade.tpo.electromarket.exceptions.UsuarioDuplicadoException;
import com.uade.tpo.electromarket.exceptions.UsuarioNoExisteException;
import com.uade.tpo.electromarket.service.UsuarioService;


@RestController
@RequestMapping("usuarios")

public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping()
    public ResponseEntity<List<Usuario>> getUsuarios() {
        return ResponseEntity.ok(this.usuarioService.getUsuarios());
    }

    @GetMapping("/{usuarioId}")
    public ResponseEntity<Usuario> getUsuarioPorId(@PathVariable long usuarioId) {
        Optional<Usuario> result = usuarioService.getUsuarioPorId(usuarioId);
        if (result.isPresent())
            return ResponseEntity.ok(result.get());

        return ResponseEntity.noContent().build();
    }    

    @PostMapping
    public ResponseEntity<Object> agregarUsuario(@RequestBody UsuarioRequest usuarioRequest) throws UsuarioDuplicadoException {
                
        Usuario result = usuarioService.agregarUsuario(usuarioRequest.getEmail(),
                                                       usuarioRequest.getFirstName(),
                                                       usuarioRequest.getLastName(),
                                                       usuarioRequest.getPassword());
        return ResponseEntity.created(URI.create("/usuarios/" + result.getId())).body(result);
    }

    @PutMapping
    public ResponseEntity<Object> actualizarUsuario(@RequestBody UsuarioRequest usuarioRequest) throws UsuarioNoExisteException {
       
        usuarioService.actualizarUsuario(usuarioRequest.getEmail(),
                                         usuarioRequest.getFirstName(),
                                         usuarioRequest.getLastName(),
                                         usuarioRequest.getPassword());
       
       return ResponseEntity.ok(usuarioRequest);
    }    

}
