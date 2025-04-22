package com.uade.tpo.electromarket.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "El usuario que se intenta agregar ya existe")
public class UsuarioDuplicadoException extends Exception{
    
}
