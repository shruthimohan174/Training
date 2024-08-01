package com.bank.mgt.system.service;

import com.bank.mgt.system.entities.Customer;
import com.bank.mgt.system.entities.Manager;
import com.bank.mgt.system.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ManagerService {

    @Autowired
    private ManagerRepository managerRepository;

    public Manager addManager(Manager Manager){
        return managerRepository.save(Manager);
    }

    public Manager updateManager(Integer id,String name){
        Manager manager=findManagerById(id);
        if(manager.getName()!=null)
            manager.setName(name);
        return  managerRepository.save(manager);
    }

    public void deleteManager(Integer id){
        Manager manager=findManagerById(id);
        managerRepository.delete(manager);
    }

    public Manager findManagerById(Integer id){
        Optional<Manager> optionalManager=managerRepository.findById(id);
        if(optionalManager.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer Not found");
        }
        return optionalManager.get();

    }

    public List<Manager> findAllManager(){
        List<Manager> managerList= managerRepository.findAll();;
        if(managerList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Customer Not found");
        }
        return managerList;    }
}
