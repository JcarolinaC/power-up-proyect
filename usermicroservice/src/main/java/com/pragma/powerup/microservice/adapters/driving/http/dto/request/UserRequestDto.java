package com.pragma.powerup.microservice.adapters.driving.http.dto.request;

import com.pragma.powerup.microservice.adapters.driven.jpa.mysql.entity.RoleEntity;
import jakarta.persistence.Column;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

@AllArgsConstructor
@Getter
@NotBlank
@NonNull
public class UserRequestDto {
    private Long id;

    @Size(min = 3, max = 13, message = "you need a name")
    private String name;

    @Size(min = 3, max = 13, message = "you need a last name")
    private String lastname;

    @Pattern(regexp = "\\d+", message = "DNI number: it must be numeric")
    @Digits(integer = 13, fraction = 0)
    @Size(min = 4, max = 13, message = "you need a dni number validate")
    @Column(unique = true, nullable = false, length = 13)
    private String dniNumber;

    @Pattern(regexp = "\\+?\\d+", message = "Phone number may be contain charcter '+' ")
    @Size(min=10 , max=13, message = "phone must be between 10 and 13 digit")
    private String phone;

    //@Pattern(regexp = "\\d{4}\\d{2}\\d{2}", message = "You need birthday format YYYY-MM-DD")
    @PastOrPresent(message = "Birthday must past date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private String birthDay;

    @Email(message = "email you need format user@domain.com")
    @Pattern(regexp = "^[A-Za-z0-9]{2,15}@[A-Za-z0-9]+(\\.[A-Za-z]{2,5}){1,2}(\\.[A-Za-z]{2,3})?$")
    private String mail;

    @NotEmpty
    private String password;

    @NotNull(message = "The idRole cannot be empty")
    private RoleEntity idRole;
}
