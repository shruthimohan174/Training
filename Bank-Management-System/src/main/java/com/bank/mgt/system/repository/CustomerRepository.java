package com.bank.mgt.system.repository;

import com.bank.mgt.system.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
