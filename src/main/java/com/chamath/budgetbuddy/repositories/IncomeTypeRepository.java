package com.chamath.budgetbuddy.repositories;

import com.chamath.budgetbuddy.models.IncomeTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IncomeTypeRepository extends JpaRepository<IncomeTypeEntity, Integer> {
}
