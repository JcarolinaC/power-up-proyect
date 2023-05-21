package com.pragma.powerup.microservice.domain.model;


public class User {
    private Long id;
    private String name;
    private String lastname;
    private String dniNumber;
    private String phone;
    private String birthday;
    private String email;
    private String password;
    private Role idRole;


    public User(Long id, String name, String lastname, String dniNumber, String phone, String birthday, String email, String password, Role idRole) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.dniNumber = dniNumber;
        this.phone = phone;
        this.birthday = birthday;
        this.email = email;
        this.password = password;
        this.idRole = idRole;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDniNumber() {
        return dniNumber;
    }

    public void setDniNumber(String dniNumber) {
        this.dniNumber = dniNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getIdRole() {
        return idRole;
    }

}
