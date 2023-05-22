package com.pragma.powerup.microservice.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastname;
    private String email;
    private String phone;
    private String birthday;
    @Column(unique = true, nullable = false, length = 20)
    private String dniNumber;
    private String password;
    @ManyToOne
    @JoinColumn(name = "id_role")
    private RoleEntity idRole;
    private String tokenPassword;
}
