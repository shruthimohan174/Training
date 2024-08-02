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

    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    public Account(Integer id, Double balance, Integer customerId, AccountType accountType) {
        this.id = id;
        this.balance = balance;
        this.customerId = customerId;
        this.accountType = accountType;
    }

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

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType account) {
        this.accountType = account;
    }

    public Account(){

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(id, account.id) && Objects.equals(balance, account.balance) && Objects.equals(customerId, account.customerId)  && accountType == account.accountType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, balance, customerId, accountType);
    }
}
