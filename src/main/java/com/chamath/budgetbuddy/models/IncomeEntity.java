package com.chamath.budgetbuddy.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "income")
public class IncomeEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    @Column(name = "income_id")
    private UUID incomeId;

    @Column(name = "income_name")
    private String incomeName;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "income_type_id", referencedColumnName = "income_type_id")
    private IncomeTypeEntity incomeTypeEntity;

    @Column(name = "income_date")
    private Date incomeDate;
}
