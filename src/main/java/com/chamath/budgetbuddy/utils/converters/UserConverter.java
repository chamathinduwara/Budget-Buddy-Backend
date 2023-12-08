package com.chamath.budgetbuddy.utils.converters;

import com.chamath.budgetbuddy.dto.RegistrationDto;
import com.chamath.budgetbuddy.dto.UserDto;
import com.chamath.budgetbuddy.models.RoleEntity;
import com.chamath.budgetbuddy.models.UserEntity;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserConverter {

    public UserDto toUserDto(UserEntity userEntity, UserDto userDto){
        userDto.setFirstName(userEntity.getFirstName());
        userDto.setLastName(userEntity.getLastName());
        userDto.setEmail(userEntity.getEmail());
        return userDto;
    }

    public UserEntity toUserEntity(RegistrationDto registrationDto, String passwordHash, UserEntity userEntity, RoleEntity roleEntity){
        userEntity.setFirstName(registrationDto.getFirstName());
        userEntity.setLastName(registrationDto.getLastName());
        userEntity.setEmail(registrationDto.getEmail());
        userEntity.setPasswordHash(passwordHash);


        Set<RoleEntity> roleEntitieSet = new HashSet<>();
        roleEntitieSet.add(roleEntity);
        userEntity.setRoles(roleEntitieSet);
        return userEntity;
    }
}
