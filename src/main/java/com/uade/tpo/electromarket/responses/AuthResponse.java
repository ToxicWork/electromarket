package com.uade.tpo.electromarket.responses;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class AuthResponse extends Response {
    private String token;
}
