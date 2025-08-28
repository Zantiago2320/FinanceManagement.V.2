package com.app.FinanceManagement.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "SavingMovements")
@Data
public class SavingMovement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ide_saving_movement", nullable = false, unique = true)
    private long idSavingMovement;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "movement_type", nullable = false)
    private String movementType; // Puede ser "DEPOSIT" o "WITHDRAWAL"

    @Column(name = "movement_date", nullable = false)
    private LocalDateTime movementDate;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "update_at", nullable = false)
    private LocalDateTime updateAt;

    @PrePersist
    private void prePersist() {
        LocalDateTime now = LocalDateTime.now();
        if (movementDate == null) movementDate = now;
        if (createdAt == null) createdAt = now;
        if (updateAt == null) updateAt = now;
    }
}
