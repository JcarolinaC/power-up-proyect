package com.pragma.powerup.microservice.domain.spi;



import com.pragma.powerup.microservice.domain.model.Role;

import java.util.List;

public interface IRolePersistencePort {
    List<Role> getAllRoles();
}
