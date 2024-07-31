package com.bank.mgt.system.repository;

import com.bank.mgt.system.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account,Integer> {

}
