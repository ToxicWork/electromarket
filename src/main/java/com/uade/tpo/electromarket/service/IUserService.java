package com.uade.tpo.electromarket.service;

import com.uade.tpo.electromarket.requests.LoginRequest;
import com.uade.tpo.electromarket.requests.RegisterRequest;

public interface IUserService {
    void registrarUsuario(RegisterRequest r);
    void iniciarSesion(LoginRequest l);
}
