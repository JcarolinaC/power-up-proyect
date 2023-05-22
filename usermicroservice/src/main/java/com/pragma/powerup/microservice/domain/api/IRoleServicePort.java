package com.pragma.powerup.microservice.domain.api;


import com.pragma.powerup.microservice.domain.model.Role;

import java.util.List;

public interface IRoleServicePort {
    List<Role> getAllRoles();
}
