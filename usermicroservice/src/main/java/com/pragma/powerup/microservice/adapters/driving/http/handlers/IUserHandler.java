package com.pragma.powerup.microservice.adapters.driving.http.handlers;

import com.pragma.powerup.microservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.microservice.adapters.driving.http.dto.response.UserResponseDto;


public interface IUserHandler {
    void saveUser(UserRequestDto userRequestDto);

    UserResponseDto findBydniNumber(String dniNumber);

    UserResponseDto findById(Long id);
}