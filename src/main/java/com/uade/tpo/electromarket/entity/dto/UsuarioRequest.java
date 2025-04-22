package com.uade.tpo.electromarket.entity.dto;

import lombok.Data;

@Data
public class UsuarioRequest {
    
    private long id;
    private String email;
    private String name;
    private String password;
    private String firstName;
    private String lastName;
    
}
