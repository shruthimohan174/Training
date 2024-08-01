package com.bank.mgt.system.service;

import com.bank.mgt.system.classes.CurrentAccount;
import com.bank.mgt.system.classes.RecurringAccount;
import com.bank.mgt.system.classes.SavingsAccount;
import com.bank.mgt.system.entities.Account;
import com.bank.mgt.system.entities.AccountType;
import com.bank.mgt.system.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Integer accountId,Double balance,Integer customerId,String accountType){
//        AccountType type = account.getAccountType();
        Account newAccount=null;
        switch(accountType){
            case "Current":
                newAccount=new CurrentAccount();
                break;
            case "Recurring":
                newAccount=new RecurringAccount();
                break;
            case "Savings":
                newAccount=new SavingsAccount();
                break;
            default :
                throw new IllegalArgumentException("Invalid Account Type");
        }
        if(newAccount==null)return null;
        newAccount.setId(accountId);
        newAccount.setBalance(balance);
        newAccount.setCustomerId(customerId);
        newAccount.setAccountType(AccountType.valueOf(accountType));

        return accountRepository.save(newAccount);

    }
}
