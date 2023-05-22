package com.pragma.powerup.microservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
public class LoginRequestDto {
    @NotBlank
    private String userDni;
    @NotBlank
    private String password;
}
