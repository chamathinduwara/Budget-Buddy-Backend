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
@Table(name = "expense")
public class ExpenseEntity {

    @Id
    @GeneratedValue(generator = "uuid")
    @Column(name = "expense_id")
    private UUID expenseId;

    @Column(name = "expense_name")
    private String expenseName;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserEntity userEntity;

    @ManyToOne
    @JoinColumn(name = "expense_type_id", referencedColumnName = "expense_type_id")
    private ExpenseTypeEntity expenseTypeEntity;

    @Column(name = "expense_date")
    private Date expenseDate;
}
