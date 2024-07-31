package com.bank.mgt.system.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public abstract class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Double balance;

    @Column(name = "customer_id")
    private Integer customerId;

    private List<Integer> transactionList=new ArrayList<>();

    private AccountType accountType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<Integer> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Integer> transactionList) {
        this.transactionList = transactionList;
    }

    public AccountType getAccount() {
        return accountType;
    }

    public void setAccount(AccountType account) {
        this.accountType = account;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(balance, account.balance) && Objects.equals(customerId, account.customerId) && Objects.equals(transactionList, account.transactionList) && accountType == account.accountType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, customerId, transactionList, accountType);
    }
}
