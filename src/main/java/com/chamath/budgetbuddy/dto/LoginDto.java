package com.chamath.budgetbuddy.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public final class LoginDto {

    @NonNull
    private String email;

    @NonNull
    private String password;
}
