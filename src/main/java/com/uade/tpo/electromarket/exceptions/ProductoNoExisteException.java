package com.uade.tpo.electromarket.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "El producto que se intenta actualizar no existe")
public class ProductoNoExisteException extends Exception{
    
}
