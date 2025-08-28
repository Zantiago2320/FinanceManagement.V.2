package com.app.FinanceManagement.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class FinancialProjectionDTO {
    private long idFinancialProjection;
    private BigDecimal projectedIncome;
    private BigDecimal projectedExpenses;
    private LocalDateTime projectionDate;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}