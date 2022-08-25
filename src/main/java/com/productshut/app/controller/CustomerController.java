package com.productshut.app.controller;

import com.productshut.app.model.Customer;
import com.productshut.app.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerServiceImpl service ;

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return service.addCustomer(customer) ;
    }

    @GetMapping("/fetchCustomer")
    public List<Customer> getCustomer(){
        return service.getCustomers() ;
    }
}
