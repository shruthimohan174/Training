package com.bank.mgt.system.controller;


import com.bank.mgt.system.dto.TransactionDTO;
import com.bank.mgt.system.entities.Transaction;
import com.bank.mgt.system.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping()
    public ResponseEntity<List<Transaction>>getALlTransaction(){
        List<Transaction> newTransaction=transactionService.getALlTransaction();
        return new ResponseEntity<>(newTransaction,HttpStatus.OK);
    }
}
