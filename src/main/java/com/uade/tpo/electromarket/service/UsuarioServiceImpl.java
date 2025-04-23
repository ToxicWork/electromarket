package com.uade.tpo.electromarket.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uade.tpo.electromarket.entity.Usuario;
import com.uade.tpo.electromarket.exceptions.UsuarioDuplicadoException;
import com.uade.tpo.electromarket.exceptions.UsuarioNoExisteException;
import com.uade.tpo.electromarket.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> getUsuarios() {
        
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> getUsuarioPorId(long usuarioId) {
        
        return usuarioRepository.findById(usuarioId);
    }

    public Usuario agregarUsuario(String email,String firstname, String lastname, String password) throws UsuarioDuplicadoException {
        List<Usuario> usuarios = usuarioRepository.findByEmail(email).map(List::of).orElse(Collections.emptyList());;
        
        if (usuarios.isEmpty()) {
            return usuarioRepository.save(new Usuario(email, firstname, lastname, password));
        }
        
        throw new UsuarioDuplicadoException();        
        
    }
    
    public Usuario actualizarUsuario(String email,String firstname, String lastname, String password) throws UsuarioNoExisteException{
        List<Usuario> usuarios = usuarioRepository.findByEmail(email).map(List::of).orElse(Collections.emptyList());
        if (usuarios.isEmpty()) {
            throw new UsuarioNoExisteException();
        }

        Usuario usuarioActualizado = usuarios.get(0);

        usuarioActualizado.setEmail(email);
        usuarioActualizado.setFirstName(firstname);
        usuarioActualizado.setLastName(lastname);
        usuarioActualizado.setPassword(password);

        return usuarioRepository.save(usuarioActualizado);
    }    


    public void eliminarUsuario(String email){
         List<Usuario> usuarios = usuarioRepository.findByEmail(email).map(List::of).orElse(Collections.emptyList());
        
         usuarioRepository.delete(usuarios.get(0));
    }
}
