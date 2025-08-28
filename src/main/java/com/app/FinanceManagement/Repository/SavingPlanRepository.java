package com.app.FinanceManagement.Repository;

import com.app.FinanceManagement.Entity.SavingPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingPlanRepository extends JpaRepository<SavingPlan, Long> {
}

