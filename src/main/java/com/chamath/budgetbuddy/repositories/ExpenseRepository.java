package com.chamath.budgetbuddy.repositories;

import com.chamath.budgetbuddy.models.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface ExpenseRepository extends JpaRepository<ExpenseEntity, UUID> {
}
