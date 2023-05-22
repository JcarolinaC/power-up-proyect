package com.pragma.powerup.microservice.domain.usercase;



import com.pragma.powerup.microservice.domain.api.IRoleServicePort;
import com.pragma.powerup.microservice.domain.model.Role;
import com.pragma.powerup.microservice.domain.spi.IRolePersistencePort;

import java.util.List;

public class RoleUseCase implements IRoleServicePort {

    private final IRolePersistencePort rolePersistencePort;

    public RoleUseCase(IRolePersistencePort rolePersistencePort) {
        this.rolePersistencePort = rolePersistencePort;
    }

    @Override
    public List<Role> getAllRoles() {
        return rolePersistencePort.getAllRoles();
    }
}
