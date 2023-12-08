package com.chamath.budgetbuddy.controllers;

import com.chamath.budgetbuddy.dto.LoginDto;
import com.chamath.budgetbuddy.dto.RegistrationDto;
import com.chamath.budgetbuddy.dto.UserDto;
import com.chamath.budgetbuddy.services.AuthServices;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthServices authServices;

    @PostMapping(value = "/register")
    public ResponseEntity<UserDto> register(@RequestBody RegistrationDto registrationDto){
        var responseDto = authServices.createUser(registrationDto);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String > login(@RequestBody LoginDto loginDto){
        var responseDto = authServices.getUserByEmail(loginDto);
        return ResponseEntity.ok(responseDto);
    }
}
