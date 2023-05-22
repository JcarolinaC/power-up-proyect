package com.pragma.powerup.microservice.adapters.driving.http.handlers.impl;


import com.pragma.powerup.microservice.adapters.driving.http.dto.request.UserRequestDto;

import com.pragma.powerup.microservice.adapters.driving.http.dto.response.UserResponseDto;
import com.pragma.powerup.microservice.adapters.driving.http.handlers.IUserHandler;
import com.pragma.powerup.microservice.adapters.driving.http.mapper.IUserRequestMapper;
import com.pragma.powerup.microservice.adapters.driving.http.mapper.IUserResponseMapper;
import com.pragma.powerup.microservice.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserHandlerImpl implements IUserHandler {

    private final IUserPersistencePort userPersistencePort;
    private final IUserRequestMapper userRequestMapper;
    private final IUserResponseMapper userResponseMapper;

    @Override
    public void saveUser(UserRequestDto userRequestDto) {
        userPersistencePort.saveUser(userRequestMapper.toUser(userRequestDto));
    }

    @Override
    public UserResponseDto findBydniNumber(String dniNumber) {
        return userResponseMapper.toResponse(userPersistencePort.findBydniNumber(dniNumber));
    }

    @Override
    public UserResponseDto findById(Long id) {
        return userResponseMapper.toResponse(userPersistencePort.findById(id));
    }
}
