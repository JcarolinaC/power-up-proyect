package com.pragma.powerup.microservice.adapters.driven.jpa.mysql.adapter;


import com.pragma.powerup.microservice.adapters.driven.jpa.mysql.entity.PrincipalUser;
import com.pragma.powerup.microservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import com.pragma.powerup.microservice.adapters.driven.jpa.mysql.entity.UserEntity;
import com.pragma.powerup.microservice.adapters.driven.jpa.mysql.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String dniNumber) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByDniNumber(dniNumber).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        List<UserEntity> usersEntity = userRepository.findAllById(userEntity.getId());
        if (usersEntity.isEmpty()) {
            throw new UsernameNotFoundException("User not found with Dni Number: " + dniNumber);
        }
        List<RoleEntity> roles = new ArrayList<>();

        for (UserEntity user : usersEntity) {
            roles.add(user.getIdRole());
        }

        return PrincipalUser.build(userEntity, roles);
    }
}
