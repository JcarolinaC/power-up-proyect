package com.pragma.powerup.microservice.adapters.driving.http.dto.response;

import com.pragma.powerup.microservice.domain.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserResponseDto {

    private String name;
    private String lastname;
    private String dniNumber;
    private String phone;
    private String birthday;
    private String email;
    private String password;
    private Role idRole;
}

