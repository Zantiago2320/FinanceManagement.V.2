package com.app.FinanceManagement.Repository;

import com.app.FinanceManagement.Entity.SavingMovement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SavingMovementRepository extends JpaRepository<SavingMovement, Long> {
}
