package com.bank.mgt.system.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private Double balance;

    @ManyToOne
    private Customer customer;

    @OneToMany(mappedBy = "account")
    private List<Transaction> transaction=new ArrayList<>();

    private AccountType accountType;
}
