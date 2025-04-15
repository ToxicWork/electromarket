package com.uade.tpo.electromarket.responses;

import lombok.*;
import lombok.experimental.SuperBuilder;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
@Setter
public class Response {
    protected String mensaje;
    protected HttpStatus status;
}
