package com.productshut.app.service;

import com.productshut.app.model.Customer;
import com.productshut.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository repository ;

    public Customer addCustomer(Customer customer){
        return repository.save(customer) ;
    }

    public List<Customer> getCustomers(){
        return repository.findAll() ;
    }
}
