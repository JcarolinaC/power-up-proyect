package com.pragma.powerup.microservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.microservice.adapters.driven.jpa.mysql.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    Optional<UserEntity> findByDniNumber(String dniNumber);

    Boolean existsByDniNumber(String dniNumber);

    boolean existsByEmail(String email);

    List<UserEntity> findAllById(Long id);

}
