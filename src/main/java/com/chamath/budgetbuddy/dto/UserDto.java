package com.chamath.budgetbuddy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class UserDto {
    @NonNull
    private String firstName;

    @NonNull
    private String lastName;

    @NonNull
    private String email;
}

