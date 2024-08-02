package com.bank.mgt.system.classes;

import com.bank.mgt.system.entities.Account;
import com.bank.mgt.system.repository.AccountRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class SavingsAccount extends Account {

    private Double minimumBalance=1000.00;
    private Integer maxWithdrawals=3;
    private Integer withdrawalCounts=0;

    public void deposit(Double amount){
        setBalance(getBalance() + amount);
    }

    public void withdraw(Double amount){
        if(checkWithdraw(amount)){
            withdrawalCounts++;
            setBalance((getBalance() - amount));
        }
    }

    public boolean checkWithdraw(Double amount){
         if(withdrawalCounts < maxWithdrawals && getBalance() - amount >=minimumBalance)
             return  true;
         return false;
        }


}
