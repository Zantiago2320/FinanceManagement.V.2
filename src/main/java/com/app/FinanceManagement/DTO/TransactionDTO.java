package com.app.FinanceManagement.DTO;

import java.time.LocalDateTime;

import com.app.FinanceManagement.Entity.TransactionType;
import lombok.Data;

@Data
public class TransactionDTO {
    private Long idTransaction;
    private Long userId;
    private Long idCategory;
    private TransactionType type;
    private Double amount;
    private String description;
    private LocalDateTime transactionDate;
}
