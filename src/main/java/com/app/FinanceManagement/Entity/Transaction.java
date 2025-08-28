package com.app.FinanceManagement.Entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction")
    private Long idTransaction;

    // Relación Muchos a Uno: Muchas transacciones pertenecen a un usuario
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Relación Muchos a Uno: Muchas transacciones pueden tener una categoría
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    // Tipo de transacción: INCOME, EXPENSE, etc.
    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 50)
    private TransactionType type;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "description", length = 255)
    private String description;

    @Column(name = "transaction_date", nullable = false)
    private LocalDateTime transactionDate;

    // Constructor sin parámetros (requerido por JPA)
    public Transaction() {
    }

    // Constructor con parámetros principales
    public Transaction(User user, Category category, TransactionType type, Double amount, String description) {
        this.user = user;
        this.category = category;
        this.type = type;
        this.amount = amount;
        this.description = description;
        this.transactionDate = LocalDateTime.now();
    }

    @PrePersist
    private void prePersist() {
        if (transactionDate == null) {
            transactionDate = LocalDateTime.now();
        }
    }
}