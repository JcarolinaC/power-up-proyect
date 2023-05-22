package com.pragma.powerup.microservice.adapters.driving.http.handlers.impl;


import com.pragma.powerup.microservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.pragma.powerup.microservice.adapters.driving.http.dto.response.RoleResponseDto;
import com.pragma.powerup.microservice.adapters.driving.http.handlers.IRoleHandler;
import com.pragma.powerup.microservice.adapters.driving.http.mapper.IRoleResponseMapper;
import com.pragma.powerup.microservice.domain.api.IRoleServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleHandlerImpl implements IRoleHandler {
    private final IRoleResponseMapper roleResponseMapper;
    private final IRoleServicePort roleServicePort;

    @Override
    public RoleEntity map(String value) {
        return null;
    }

    @Override
    public List<RoleResponseDto> getAllRoles() {
        return roleResponseMapper.toResponseList(roleServicePort.getAllRoles());
    }
}
