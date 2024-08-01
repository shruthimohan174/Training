package com.bank.mgt.system.repository;

import com.bank.mgt.system.entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerRepository extends JpaRepository<Manager,Integer> {
}
