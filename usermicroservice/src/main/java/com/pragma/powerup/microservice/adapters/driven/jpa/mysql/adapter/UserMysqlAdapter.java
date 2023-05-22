package com.pragma.powerup.microservice.adapters.driven.jpa.mysql.adapter;


import com.pragma.powerup.microservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.pragma.powerup.microservice.adapters.driven.jpa.mysql.exceptions.EmailAlreadyExistsException;
import com.pragma.powerup.microservice.adapters.driven.jpa.mysql.exceptions.PersonAlreadyExistsException;
import com.pragma.powerup.microservice.adapters.driven.jpa.mysql.exceptions.UserNotFoundException;
import com.pragma.powerup.microservice.adapters.driven.jpa.mysql.mappers.IUserEntityMapper;
import com.pragma.powerup.microservice.adapters.driven.jpa.mysql.repositories.IUserRepository;
import com.pragma.powerup.microservice.domain.model.User;
import com.pragma.powerup.microservice.domain.spi.IUserPersistencePort;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

@RequiredArgsConstructor
public class UserMysqlAdapter implements IUserPersistencePort {
    private final IUserRepository userRepository;
    private final IUserEntityMapper userEntityMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void saveUser(User user) {
        if (userRepository.findByDniNumber(user.getDniNumber()).isPresent()) {
            throw new PersonAlreadyExistsException();
        }
        if (Boolean.TRUE.equals(userRepository.existsByDniNumber(user.getDniNumber()))){
            throw new PersonAlreadyExistsException();
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new EmailAlreadyExistsException();
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserEntity testUser = userEntityMapper.toEntity(user);
        userRepository.save(testUser);
    }
    @Override
    public User findBydniNumber(String dniNumber) {
        Optional<UserEntity> user = userRepository.findByDniNumber(dniNumber);
        if (userRepository.findByDniNumber(dniNumber).isPresent()) {
            return userEntityMapper.ofUserEntityToUser(user.get());
        }
            throw new UserNotFoundException();
    }
    @Override
    public User findById(Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (userRepository.findById(id).isPresent()) {
            return userEntityMapper.ofUserEntityToUser(user.get());
        }
        throw new UserNotFoundException();
    }
}