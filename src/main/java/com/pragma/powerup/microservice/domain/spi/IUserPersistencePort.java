package com.pragma.powerup.microservice.domain.spi;


import com.pragma.powerup.microservice.domain.model.User;

public interface IUserPersistencePort {
    void saveUser(User user);

    User findBydniNumber(String dniNumber);


    User findById(Long id);

}
