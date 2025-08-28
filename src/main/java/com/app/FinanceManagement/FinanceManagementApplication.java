package com.app.FinanceManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FinanceManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinanceManagementApplication.class, args);
	}

}


/*
Users
POST /api/users/create
JSON: { "name": "Juan Perez", "email": "juan@example.com", "password": "123456", "role": "USER" }

Categories
POST /api/categories/create
JSON: { "name": "Salario" }

Transactions
POST /api/transactions/create x
Requiere userId y idCategory existentes; type admite INCOME, EXPENSE, TRANSFER.
JSON: { "userId": 1, "idCategory": 1, "type": "INCOME", "amount": 100.0, "description": "Pago mensual" }
Opcional: "transactionDate": "2025-08-26T12:00:00"

Saving Plans
POST /api/savingplans/create
JSON: { "planName": "Fondo de emergencia", "targetAmount": 10000.00, "durationMonths": 12, "createdAt": "2025-08-26T12:00:00", "updateAt": "2025-08-26T12:00:00" }

Saving Movements
POST /api/savingmovements/create
JSON: { "amount": 250.00, "movementType": "DEPOSIT" }

Financial Projections
POST /api/financialprojections/create x
JSON: { "projectedIncome": 5000.00, "projectedExpenses": 3200.00 }

Capitalization Settings
POST /api/capitalizationsettings/create
JSON: { "interestRate": 0.08, "capitalizationFrequency": "MENSUAL", "createdAt": "2025-08-26T12:00:00", "updateAt": "2025-08-26T12:00:00" }
 */