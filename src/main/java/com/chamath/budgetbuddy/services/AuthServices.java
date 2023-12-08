package com.chamath.budgetbuddy.services;

import com.chamath.budgetbuddy.dto.RegistrationDto;
import com.chamath.budgetbuddy.dto.UserDto;
import com.chamath.budgetbuddy.models.UserEntity;
import com.chamath.budgetbuddy.repositories.UserRepository;
import com.chamath.budgetbuddy.utils.converters.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.stream.DoubleStream;


@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final  UserConverter userConverter;

    public UserDto createUser(RegistrationDto registrationDto){
        var userEntity = new UserEntity();
        userEntity = userConverter.toUserEntity(registrationDto, passwordEncoder.encode(registrationDto.getPassword()), userEntity);
        userEntity = userRepository.save(userEntity);
        return userConverter.toUserDto(userEntity, new UserDto());
    }
}
