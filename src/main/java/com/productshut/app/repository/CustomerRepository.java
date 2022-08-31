package com.productshut.app.repository;

import com.productshut.app.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    public Customer findByEmailIdAndPhoneNo(String email, String password) ;
}
