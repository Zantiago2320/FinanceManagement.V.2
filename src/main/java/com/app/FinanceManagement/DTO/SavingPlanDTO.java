package com.app.FinanceManagement.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class SavingPlanDTO {
    private long idSavingPlan;
    private String planName;
    private BigDecimal targetAmount;
    private int durationMonths;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}
