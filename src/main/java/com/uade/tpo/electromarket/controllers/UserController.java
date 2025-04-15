package com.uade.tpo.electromarket.controllers;

import com.uade.tpo.electromarket.requests.RegisterRequest;
import com.uade.tpo.electromarket.responses.AuthResponse;
import com.uade.tpo.electromarket.responses.Response;
import com.uade.tpo.electromarket.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserController {

    @Autowired
    private IUserService iUserService;

    @PostMapping("/register")
    public ResponseEntity<Response> registrarUsuario(@RequestBody RegisterRequest r) {
        try {
            System.out.println("hola 1");
            iUserService.registrarUsuario(r);
            return ResponseEntity.status(HttpStatus.CREATED).body(
                    AuthResponse.builder()
                            .mensaje("Registro exitoso")
                            .status(HttpStatus.CREATED)
                            .token("Token de auth")
                            .build()
            );
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(
                    Response.builder()
                            .mensaje(e.getMessage())
                            .status(HttpStatus.CONFLICT)
                            .build()
            );
        }
    }
}
