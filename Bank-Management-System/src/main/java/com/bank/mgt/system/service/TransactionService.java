package com.bank.mgt.system.service;

import com.bank.mgt.system.entities.Transaction;
import com.bank.mgt.system.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction createTransaction(Integer accountId, Double amount, LocalDateTime timestamp, String transactionType) {
        Transaction transaction=new Transaction();
        transaction.setTransactionType(transactionType);
        transaction.setAccountId(accountId);
        transaction.setAmount(amount);
        transaction.setTimestamp(timestamp);
    return transactionRepository.save(transaction);
    }

    public List<Transaction> getALlTransaction(){
        List<Transaction> transactionList=transactionRepository.findAll();
        return transactionRepository.saveAll(transactionList);
    }

    public Transaction getTransactionById(Integer id) throws Exception {
        Optional<Transaction>optionalTransaction= transactionRepository.findById(id);
        if(!optionalTransaction.isPresent()){
            throw new Exception("Transaction not found");
        }
        return optionalTransaction.get();
    }
}
