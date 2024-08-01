package com.bank.mgt.system.controller;

import com.bank.mgt.system.dto.AccountDTO;
import com.bank.mgt.system.entities.Account;
import com.bank.mgt.system.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping()
    public ResponseEntity<?> createAccount(@RequestBody AccountDTO account){
         try{
            Account account1=accountService.createAccount(account.getAccountId(),account.getBalance(),account.getCustomerId(),account.getAccountType().toString());
            return new ResponseEntity<>(account1, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
