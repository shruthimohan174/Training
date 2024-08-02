package com.bank.mgt.system.service;

import com.bank.mgt.system.classes.CurrentAccount;
import com.bank.mgt.system.classes.RecurringAccount;
import com.bank.mgt.system.classes.SavingsAccount;
import com.bank.mgt.system.entities.Account;
import com.bank.mgt.system.entities.AccountType;
import com.bank.mgt.system.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Integer accountId,Double balance,Integer customerId,String accountType){
//        AccountType type = account.getAccountType();
        Account newAccount=null;
        switch(accountType){
            case "Current"->  newAccount=new CurrentAccount();
            case "Recurring" -> newAccount=new RecurringAccount();
            case "Savings"->  newAccount=new SavingsAccount();
            default -> throw new IllegalArgumentException("Invalid Account Type");
        }
        if(newAccount==null)return null;
        newAccount.setId(accountId);
        newAccount.setBalance(balance);
        newAccount.setCustomerId(customerId);
        newAccount.setAccountType(AccountType.valueOf(accountType));

        return accountRepository.save(newAccount);
    }

    public void depositMoney(Integer accountId, Double amount) throws Exception {
        Account account=findByAccountId(accountId);
        if(account instanceof SavingsAccount sa){
            sa.deposit(amount);
        }
        else if(account instanceof CurrentAccount ca){
            ca.deposit(amount);
        }
        else if(account instanceof RecurringAccount ra){
            ra.deposit(amount);
        }
        else {
            throw  new Exception("Invalid Account Type");
        }
            accountRepository.save(account);
    }

    public void withdrawMoney(Integer accountId, Double amount) throws Exception{
        Account account=findByAccountId(accountId);
        if(account instanceof SavingsAccount sa){
            sa.withdraw(amount);
        }
        else if(account instanceof CurrentAccount ca){
            ca.withdraw(amount);
        }
        else if(account instanceof RecurringAccount ra){
            ra.withdraw(amount);
        }
        else {
            throw  new Exception("Invalid Account Type");
        }
        accountRepository.save(account);
    }


    public List<Account> getAllAccounts() {
        List<Account> accountList=accountRepository.findAll();
        return accountRepository.saveAll(accountList);
    }
    public Account findByAccountId(Integer accountId) throws Exception {
        Optional<Account>optionalAccount= accountRepository.findById(accountId);
        if(!optionalAccount.isPresent()){
            throw new Exception("Account not found");
        }
        return optionalAccount.get();
    }
}
