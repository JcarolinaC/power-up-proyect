package com.pragma.powerup.microservice.configuration;


import com.pragma.powerup.microservice.adapters.driven.jpa.mysql.adapter.RoleMysqlAdapter;
import com.pragma.powerup.microservice.adapters.driven.jpa.mysql.adapter.UserMysqlAdapter;
import com.pragma.powerup.microservice.adapters.driven.jpa.mysql.mappers.IRoleEntityMapper;
import com.pragma.powerup.microservice.adapters.driven.jpa.mysql.mappers.IUserEntityMapper;
import com.pragma.powerup.microservice.adapters.driven.jpa.mysql.repositories.IRoleRepository;
import com.pragma.powerup.microservice.adapters.driven.jpa.mysql.repositories.IUserRepository;
import com.pragma.powerup.microservice.domain.api.IRoleServicePort;
import com.pragma.powerup.microservice.domain.api.IUserServicePort;
import com.pragma.powerup.microservice.domain.spi.IRolePersistencePort;
import com.pragma.powerup.microservice.domain.spi.IUserPersistencePort;
import com.pragma.powerup.microservice.domain.usercase.RoleUseCase;
import com.pragma.powerup.microservice.domain.usercase.UserUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IRoleRepository roleRepository;
    private final IUserRepository userRepository;
    private final IRoleEntityMapper roleEntityMapper;
    private final IUserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public IRoleServicePort roleServicePort() {
        return new RoleUseCase(rolePersistencePort());
    }

    @Bean
    public IRolePersistencePort rolePersistencePort() {
        return new RoleMysqlAdapter(roleRepository, roleEntityMapper);
    }

    @Bean
    public IUserServicePort userServicePort() {
        return new UserUseCase(userPersistencePort());
    }

    @Bean
    public IUserPersistencePort userPersistencePort() {
        return new UserMysqlAdapter(userRepository,  userEntityMapper,passwordEncoder);
    }
}