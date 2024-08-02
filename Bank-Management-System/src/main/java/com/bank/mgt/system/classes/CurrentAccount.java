package com.bank.mgt.system.classes;

import com.bank.mgt.system.entities.Account;
import jakarta.persistence.Entity;

@Entity
public class CurrentAccount extends Account {

    private Double overdraftLimit=500.0;

    public void deposit(Double amount){
        setBalance(getBalance()+amount);
    }

    public void withdraw(Double amount) throws Exception {
        if(checkWithdraw(amount))
            setBalance(getBalance() - amount);
        else
            throw new Exception("Cannot Withdraw, Overdraft Limit reached!! ");
    }

    public boolean checkWithdraw(Double amount){
        return getBalance() + overdraftLimit >=amount;
    }

}
