package com.pragma.powerup.microservice.domain.api;

import com.pragma.powerup.microservice.domain.model.User;

public interface IUserServicePort {
    void saveUser(User user);


    User findBydniNumber(String dniNumber);

    User findById(Long id);
}
