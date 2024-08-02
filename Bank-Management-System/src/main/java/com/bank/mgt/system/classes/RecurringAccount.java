package com.bank.mgt.system.classes;

import com.bank.mgt.system.entities.Account;
import jakarta.persistence.Entity;

@Entity
public class RecurringAccount extends Account {
    private Double monthlyDeposit=500.0;
    private Integer maturityMonths=12;
    private Integer monthsDeposited=0;

    public void deposit(Double amount) throws IllegalArgumentException {
        if (amount.equals(monthlyDeposit)){
            setBalance(getBalance() + amount);
            monthsDeposited++;
        }
        else{
            throw new IllegalArgumentException("Deposit amount must be equal to fixed monthly deposit amount.");
        }
    }

    public void withdraw(Double amount) throws Exception {
        if(checkWithdraw()){
            setBalance(getBalance() - amount);
        }
        else {
            throw new Exception("Withdrawal not possible before maturity.");
        }
    }

    public boolean checkWithdraw(){
        if(monthsDeposited>=maturityMonths){
            return true;
        }
        return false;
    }
}
