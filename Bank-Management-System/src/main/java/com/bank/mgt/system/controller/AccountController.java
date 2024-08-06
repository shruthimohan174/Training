package com.bank.mgt.system.controller;

import com.bank.mgt.system.dto.AccountDTO;
import com.bank.mgt.system.entities.Account;
import com.bank.mgt.system.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/{id}/deposit")
    public ResponseEntity<String> depositMoney(@PathVariable Integer id,@RequestParam Double amount){
        try{
         accountService.depositMoney(id,amount);
            return new ResponseEntity<>("Deposit Successful: "+amount,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{id}/withdraw")
    public ResponseEntity<String> withdrawMoney(@PathVariable Integer id,@RequestParam Double amount){
        try{
            accountService.withdrawMoney(id,amount);
            return new ResponseEntity<>("Withdraw Successful: "+amount,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping()
    public ResponseEntity<List<Account>> getAllAccounts(){

        List<Account> accountList=accountService.getAllAccounts();
        return new ResponseEntity<>(accountList, HttpStatus.OK);
    }
}
