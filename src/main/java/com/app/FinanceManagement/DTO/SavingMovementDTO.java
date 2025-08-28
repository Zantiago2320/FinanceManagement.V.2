package com.app.FinanceManagement.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import lombok.Data;

@Data
public class SavingMovementDTO {
    private long idSavingMovement;
    private BigDecimal amount;
    private String movementType; // Puede ser "DEPOSIT" o "WITHDRAWAL"
    private LocalDateTime movementDate;
    private LocalDateTime createdAt;
    private LocalDateTime updateAt;
}

