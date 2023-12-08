package com.chamath.budgetbuddy.repositories;

import com.chamath.budgetbuddy.models.ExpenseTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseTypeRepository extends JpaRepository<ExpenseTypeEntity, Integer> {
}
