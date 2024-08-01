package com.bank.mgt.system.service;

import com.bank.mgt.system.entities.Customer;
import com.bank.mgt.system.entities.Manager;
import com.bank.mgt.system.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public Customer addCustomer(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Integer id,String name){
        Customer customer=findCustomerById(id);
        if(customer.getName()!=null)
            customer.setName(name);
      return  customerRepository.save(customer);
    }

    public void deleteCustomer(Integer id){
        Customer customer=findCustomerById(id);
        customerRepository.delete(customer);
    }

    public Customer findCustomerById(Integer id){
        Optional<Customer> optionalCustomer=customerRepository.findById(id);
        if(optionalCustomer.isEmpty()){
            return null;
        }
        return optionalCustomer.get();
    }

    public List<Customer> findAllCustomer(){
        List<Customer> customerList= customerRepository.findAll();;
        if(customerList.isEmpty()){
            return null;
        }
        return customerList;
    }
}
