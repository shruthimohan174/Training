package com.bank.mgt.system.controller;

import com.bank.mgt.system.entities.Customer;
import com.bank.mgt.system.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping()
    public ResponseEntity<Customer> addCustomer(Customer customer){
        Customer newCustomer=customerService.addCustomer(customer);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Integer id, @RequestBody String name) {
        Customer newCustomer = customerService.updateCustomer(id, name);
        if (newCustomer == null) {
            return new ResponseEntity<>(newCustomer, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(newCustomer, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity <List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.findAllCustomer();
        if (customers == null || customers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(customers, HttpStatus.OK);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity <Customer> deleteCustomerById(@PathVariable Integer id){
        customerService.deleteCustomer(id);
            return new ResponseEntity<>(HttpStatus.OK);
    }

}
