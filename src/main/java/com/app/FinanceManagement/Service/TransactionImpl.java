package com.app.FinanceManagement.Service;

import com.app.FinanceManagement.DTO.TransactionDTO;
import com.app.FinanceManagement.Entity.Category;
import com.app.FinanceManagement.Entity.Transaction;
import com.app.FinanceManagement.Entity.User;
import com.app.FinanceManagement.Exceptions.CustomException;
import com.app.FinanceManagement.Repository.CategoryRepository;
import com.app.FinanceManagement.Repository.TransactionRepository;
import com.app.FinanceManagement.Repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TransactionImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TransactionImpl(TransactionRepository transactionRepository, CategoryRepository categoryRepository, UserRepository userRepository, ModelMapper modelMapper) {
        this.transactionRepository = transactionRepository;
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public TransactionDTO createTransaction(TransactionDTO transactionDTO) {
        if (transactionDTO.getUserId() == null) {
            throw new CustomException("User ID cannot be null");
        }
        if (transactionDTO.getIdCategory() == null) {
            throw new CustomException("Category ID cannot be null");
        }

        Transaction transaction = modelMapper.map(transactionDTO, Transaction.class);

        User user = userRepository.findById(transactionDTO.getUserId())
                .orElseThrow(() -> new CustomException("User not found with id: " + transactionDTO.getUserId()));
        transaction.setUser(user);

        Category category = categoryRepository.findById(transactionDTO.getIdCategory())
                .orElseThrow(() -> new CustomException("Category not found with id: " + transactionDTO.getIdCategory()));
        transaction.setCategory(category);

        if (transaction.getTransactionDate() == null) {
            transaction.setTransactionDate(LocalDateTime.now());
        }

        Transaction savedTransaction = transactionRepository.save(transaction);
        return modelMapper.map(savedTransaction, TransactionDTO.class);
    }

    @Override
    public TransactionDTO updateTransaction(Long id, TransactionDTO transactionDTO) {
        if (transactionDTO.getUserId() == null) {
            throw new CustomException("User ID cannot be null");
        }
        if (transactionDTO.getIdCategory() == null) {
            throw new CustomException("Category ID cannot be null");
        }

        Transaction existingTransaction = transactionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Transaction not found with id: " + id));

        User user = userRepository.findById(transactionDTO.getUserId())
                .orElseThrow(() -> new CustomException("User not found with id: " + transactionDTO.getUserId()));

        Category category = categoryRepository.findById(transactionDTO.getIdCategory())
                .orElseThrow(() -> new CustomException("Category not found with id: " + transactionDTO.getIdCategory()));

        modelMapper.map(transactionDTO, existingTransaction);
        existingTransaction.setUser(user);
        existingTransaction.setCategory(category);

        Transaction updatedTransaction = transactionRepository.save(existingTransaction);
        return modelMapper.map(updatedTransaction, TransactionDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TransactionDTO> getTransactionsByUserId(Long userId) {
        List<Transaction> transactions = transactionRepository.findByUserIdUser(userId);
        return transactions.stream()
                .map(tx -> modelMapper.map(tx, TransactionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public TransactionDTO getTransactionById(Long id) {
        Transaction transaction = transactionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Transaction not found with id: " + id));
        return modelMapper.map(transaction, TransactionDTO.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TransactionDTO> getAllTransactions() {
        List<Transaction> transactions = transactionRepository.findAll();
        return transactions.stream()
                .map(transaction -> modelMapper.map(transaction, TransactionDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteTransaction(Long id) {
        if (!transactionRepository.existsById(id)) {
            return false;
        }
        transactionRepository.deleteById(id);
        return true;
    }
}