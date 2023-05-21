package com.pragma.powerup.microservice.adapters.driven.jpa.mysql.repositories;


import com.pragma.powerup.microservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<RoleEntity, Long> {}
