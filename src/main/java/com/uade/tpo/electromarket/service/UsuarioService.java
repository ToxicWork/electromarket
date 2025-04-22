package com.uade.tpo.electromarket.service;

import java.util.List;
import java.util.Optional;

import com.uade.tpo.electromarket.entity.Usuario;
import com.uade.tpo.electromarket.exceptions.UsuarioDuplicadoException;
import com.uade.tpo.electromarket.exceptions.UsuarioNoExisteException;

public interface UsuarioService {
    public List<Usuario> getUsuarios();
    public Optional<Usuario> getUsuarioPorId(long usuarioId);
    public Usuario agregarUsuario(String email,String firstname, String lastname, String password) throws UsuarioDuplicadoException;
    public Usuario actualizarUsuario(String email,String firstname, String lastname, String password) throws UsuarioNoExisteException;
}
