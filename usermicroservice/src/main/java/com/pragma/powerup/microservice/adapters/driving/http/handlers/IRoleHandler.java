package com.pragma.powerup.microservice.adapters.driving.http.handlers;

import com.pragma.powerup.microservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.pragma.powerup.microservice.adapters.driving.http.dto.response.RoleResponseDto;

import java.util.List;

public interface IRoleHandler {
    RoleEntity map(String value);
    List<RoleResponseDto> getAllRoles();
}
