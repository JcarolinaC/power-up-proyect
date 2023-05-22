package com.pragma.powerup.microservice.adapters.driving.http.mapper;

import com.pragma.powerup.microservice.adapters.driving.http.dto.request.UserRequestDto;
import com.pragma.powerup.microservice.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserRequestMapper {

    User toUser(UserRequestDto userRequestDto);
}
