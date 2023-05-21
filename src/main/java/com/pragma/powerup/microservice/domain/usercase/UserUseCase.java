package com.pragma.powerup.microservice.domain.usercase;


import com.pragma.powerup.microservice.adapters.driven.jpa.mysql.exceptions.UserItsNotOlder;
import com.pragma.powerup.microservice.domain.api.IUserServicePort;
import com.pragma.powerup.microservice.domain.model.User;
import com.pragma.powerup.microservice.domain.spi.IUserPersistencePort;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class UserUseCase implements IUserServicePort {
    private final IUserPersistencePort userPersistencePort;

    public UserUseCase(IUserPersistencePort userPersistencePort) {
        this.userPersistencePort = userPersistencePort;
    }

    @Override
    public void saveUser(User user) {
        LocalDate birthday = LocalDate.parse(user.getBirthday(), DateTimeFormatter.ofPattern("YYYY-MM-DD"));
        int age = Period.between(birthday, LocalDate.now()).getYears();
        if (age < 18) {
            throw new UserItsNotOlder();
        }
        userPersistencePort.saveUser(user);
    }
    @Override
    public User findBydniNumber(String dniNumber) {
        return userPersistencePort.findBydniNumber(dniNumber);
    }

    @Override
    public User findById(Long id) {
        return userPersistencePort.findById(id);
    }

}
