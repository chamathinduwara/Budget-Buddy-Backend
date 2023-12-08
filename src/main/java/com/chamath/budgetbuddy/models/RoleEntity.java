package com.chamath.budgetbuddy.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.management.relation.Role;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "role")
public class RoleEntity {



    public enum ROLE {
        ROLE_USER,
        ROLE_ADMIN
    }

    @Id
    @Column(name = "role_id", unique = true)
    private Integer Id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_name")
    private ROLE role;

//    public String toString() {
//        return role.name();
//    }
}
