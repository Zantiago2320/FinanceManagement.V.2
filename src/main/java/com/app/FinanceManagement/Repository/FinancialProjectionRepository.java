package com.app.FinanceManagement.Repository;

import com.app.FinanceManagement.Entity.FinancialProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinancialProjectionRepository extends JpaRepository<FinancialProjection, Long> {
}
