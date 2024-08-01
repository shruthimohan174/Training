package com.bank.mgt.system.service;

import com.bank.mgt.system.entities.AccountType;
import com.bank.mgt.system.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

//    public Account addAccount(AccountType accountType,Integer customerId,Double balance){

//    }
}
