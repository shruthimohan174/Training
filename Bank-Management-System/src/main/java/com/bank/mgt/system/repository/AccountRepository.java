package com.bank.mgt.system.repository;

import com.bank.mgt.system.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account,Integer> {

//    @Modifying
//    @Query("UPDATE Account a SET a.balance=a.balance+ :amount WHERE a.id= :accountId")
//    public void deposit(@Param("amount") Double amount, @Param("accountId") Integer accountId);
//
//
//    @Modifying
//    @Query("UPDATE Account a SET a.balance=a.balance - :amount WHERE a.id= :accountId")
//    public void withdraw(@Param("amount") Double amount, @Param("accountId") Integer accountId);

}
