package com.app.FinanceManagement.Service;

import com.app.FinanceManagement.DTO.TransactionDTO;
import java.util.List;

public interface TransactionService {

    TransactionDTO createTransaction(TransactionDTO transactionDTO);

    TransactionDTO getTransactionById(Long transactionId);

    List<TransactionDTO> getAllTransactions();

    TransactionDTO updateTransaction(Long transactionId, TransactionDTO transactionDTO);

    List<TransactionDTO> getTransactionsByUserId(Long userId);

    boolean deleteTransaction(Long transactionId);
}
