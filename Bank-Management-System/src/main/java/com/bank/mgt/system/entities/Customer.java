package com.bank.mgt.system.entities;

import jakarta.persistence.*;

import javax.security.auth.login.AccountException;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String name;

    @OneToMany(mappedBy = "customer")
    private List<Account> account=new ArrayList<>();

    @ManyToOne
    private Manager manager;
}
