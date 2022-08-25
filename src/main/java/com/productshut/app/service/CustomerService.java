package com.productshut.app.service;

import com.productshut.app.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer addCustomer(Customer customer) ;
    public List<Customer> getCustomers() ;
}
