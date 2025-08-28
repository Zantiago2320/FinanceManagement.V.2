package com.app.FinanceManagement.Entity;

public enum TransactionType {
    INCOME("Ingreso"),
    EXPENSE("Gasto"),
    TRANSFER("Transferencia");

    private final String displayName;

    TransactionType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}