package com.pragma.powerup.microservice.adapters.driving.http.controller;


import com.pragma.powerup.microservice.adapters.driving.http.dto.request.UserRequestDto;

import com.pragma.powerup.microservice.adapters.driving.http.dto.response.UserResponseDto;
import com.pragma.powerup.microservice.adapters.driving.http.handlers.IUserHandler;
import com.pragma.powerup.microservice.configuration.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@SecurityRequirement(name = "jwt")
public class UserRestController {
    private final IUserHandler userHandler;

    @Operation(summary = "Add a new user",
            responses = {
                    @ApiResponse(responseCode = "201", description = "User created",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "409", description = "User already exists",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error"))),
                    @ApiResponse(responseCode = "403", description = "Role not allowed for user creation",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @PostMapping("")
    public ResponseEntity<Map<String, String>> saveUser(@RequestBody UserRequestDto userRequestDto) {
        userHandler.saveUser(userRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Collections.singletonMap(Constants.RESPONSE_MESSAGE_KEY, Constants.USER_CREATED_MESSAGE));
    }

    @Operation(summary = "Get user by DNI",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User found",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "500", description = "Error internal Server",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("/dniNumber/{dniNumber}")
    public ResponseEntity<UserResponseDto> getFinbBydniNumber(@PathVariable String dniNumber) {
        return  ResponseEntity.ok(userHandler.findBydniNumber(dniNumber));
    }

    @Operation(summary = "Get user by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User found",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Map"))),
                    @ApiResponse(responseCode = "500", description = "Error internal Server",
                            content = @Content(mediaType = "application/json", schema = @Schema(ref = "#/components/schemas/Error")))})
    @GetMapping("/id/{id}")
    public ResponseEntity<UserResponseDto> getUserByid(@PathVariable Long id) {
        return ResponseEntity.ok(userHandler.findById(id));
    }
}