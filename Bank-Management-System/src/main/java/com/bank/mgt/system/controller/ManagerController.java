package com.bank.mgt.system.controller;

import com.bank.mgt.system.entities.Manager;
import com.bank.mgt.system.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @PostMapping()
    public ResponseEntity<Manager> addManager(Manager manager) {
        Manager newManager = managerService.addManager(manager);
        return new ResponseEntity<>(newManager, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Manager> updateManager(@PathVariable Integer id, @RequestBody String name) {

        Manager newManager = managerService.updateManager(id, name);
        if(newManager==null){
            return new ResponseEntity<>(newManager, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(newManager, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Manager>> getAllManagers() {
        List<Manager> newManager = managerService.findAllManager();
        if(newManager==null){
            return new ResponseEntity<>(newManager, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(newManager, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Manager> deleteManagerById(@PathVariable Integer id) {
        managerService.deleteManager(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}