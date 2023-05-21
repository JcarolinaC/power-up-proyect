package com.pragma.powerup.microservice.domain.usercase;

import com.pragma.powerup.microservice.domain.model.Role;
import com.pragma.powerup.microservice.domain.model.User;
import com.pragma.powerup.microservice.domain.spi.IUserPersistencePort;
import jakarta.validation.constraints.NotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UserUseCaseTest {
    @InjectMocks
    UserUseCase userUseCase;
    @Mock
    private IUserPersistencePort userPersistencePort;

    @BeforeEach
    void setUp() {

    }

    @Test
    void saveUser() {
    }


    @Test
    void findBydniNumber() {
        Role role = new Role(2L, "John", "This is a Owner");
        User user = new User(2l,"Juan", "Mill","123456789","+3542580178","1990-01-01","john.doe@example.com","password123",role);
        Mockito.when(userPersistencePort.findBydniNumber(Mockito.anyString())).thenReturn(user);
        User result = userUseCase.findBydniNumber("123456789");
        assertEquals(user, result);
        Mockito.verify(userPersistencePort, Mockito.times(1)).findBydniNumber("123456789");

    }

    @Test
    void findById() {
    }
}
