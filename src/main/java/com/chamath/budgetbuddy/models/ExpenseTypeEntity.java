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
@Table(name = "expense_type")
public class ExpenseTypeEntity {

    @Id
    @Column(name = "expense_type_id")
    private Integer expenseTypeId;

    @Column(name = "expense_type_name")
    private String expenseTypeName;
}
