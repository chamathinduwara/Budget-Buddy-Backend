package com.chamath.budgetbuddy.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "income_type")
public class IncomeTypeEntity {

    @Id
    @Column(name = "income_type_id")
    private Integer incomeTypeId;

    @Column(name = "income_type_name")
    private String incomeTypeName;
}
