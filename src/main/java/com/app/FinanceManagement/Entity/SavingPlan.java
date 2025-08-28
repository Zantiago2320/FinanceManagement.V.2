package com.app.FinanceManagement.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "SavingPlans")
@Data
public class SavingPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ide_saving_plan", nullable = false, unique = true)
    private long idSavingPlan;

    @Column(name = "plan_name", nullable = false, length = 100)
    private String planName;

    @Column(name = "target_amount", nullable = false)
    private BigDecimal targetAmount;

    @Column(name = "duration_months", nullable = false)
    private int durationMonths;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

}
