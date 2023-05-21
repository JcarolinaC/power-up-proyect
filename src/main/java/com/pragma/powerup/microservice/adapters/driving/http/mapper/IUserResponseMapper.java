package com.pragma.powerup.microservice.adapters.driving.http.mapper;



import com.pragma.powerup.microservice.adapters.driving.http.dto.response.UserResponseDto;
import com.pragma.powerup.microservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)

public interface IUserResponseMapper {
    @Mapping(target = "name", source = "user.name")
    @Mapping(target = "lastname", source = "user.lastname")
    @Mapping(target = "email", source = "user.email")
    @Mapping(target = "phone", source = "user.phone")
    @Mapping(target = "birthday", source = "user.birthday")
    @Mapping(target = "dniNumber", source = "user.dniNumber")
    @Mapping(target = "idRole", source = "user.idRole")
    UserResponseDto toResponse(User user);
    List<UserResponseDto> toResponseList(List<User> userList);

}
