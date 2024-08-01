package com.bank.mgt.system.classes;

import com.bank.mgt.system.entities.Account;
import com.bank.mgt.system.repository.AccountRepository;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class SavingsAccount extends Account {
}
