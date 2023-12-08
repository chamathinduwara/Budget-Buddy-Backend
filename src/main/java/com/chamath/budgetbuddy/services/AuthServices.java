package com.chamath.budgetbuddy.services;

import com.chamath.budgetbuddy.dto.LoginDto;
import com.chamath.budgetbuddy.dto.RegistrationDto;
import com.chamath.budgetbuddy.dto.UserDto;
import com.chamath.budgetbuddy.models.RoleEntity;
import com.chamath.budgetbuddy.models.UserEntity;
import com.chamath.budgetbuddy.repositories.RoleRepository;
import com.chamath.budgetbuddy.repositories.UserRepository;
import com.chamath.budgetbuddy.utils.converters.UserConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class AuthServices {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final  UserConverter userConverter;
    private final AuthenticationManager authenticationManager;

    public UserDto createUser(RegistrationDto registrationDto) {
        var userEntity = new UserEntity();
        var role = new RoleEntity(1, RoleEntity.ROLE.ROLE_USER);
        roleRepository.save(role);
        userEntity = userConverter.toUserEntity(registrationDto, passwordEncoder.encode(registrationDto.getPassword()), userEntity, role);
        userEntity = userRepository.save(userEntity);
        return userConverter.toUserDto(userEntity, new UserDto());
    }

    public String getUserByEmail(LoginDto loginDto){

        Authentication authentication1 =
                authenticationManager.authenticate
                        (new UsernamePasswordAuthenticationToken
                                (loginDto.getEmail(), loginDto.getPassword()));
        var user = userRepository.findByEmail(loginDto.getEmail());
        if (user == null){
            throw new UsernameNotFoundException("User Not Found" + loginDto);
        }
        return "Pass";
    }

}
