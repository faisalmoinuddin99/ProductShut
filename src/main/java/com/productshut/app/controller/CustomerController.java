package com.productshut.app.controller;

import com.productshut.app.dto.CustomerDTO;
import com.productshut.app.model.Customer;
import com.productshut.app.service.CustomerServiceImpl;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class CustomerController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class) ;

    @Autowired
    CustomerServiceImpl service ;

    @Autowired
    ModelMapper modelMapper ;

    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return service.addCustomer(customer) ;
    }

    @GetMapping("/fetchCustomer")
    public ResponseEntity<List<CustomerDTO>> getCustomer(){
        List<Customer> customerList = service.getCustomers() ;
        if (customerList.size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }else{
            List<CustomerDTO> customerDTOList = customerList
                    .stream()
                    .map(customer -> modelMapper.map(customer,CustomerDTO.class))
                    .collect(Collectors.toList());
            return ResponseEntity.of(Optional.of(customerDTOList)) ;
        }
    }
    @GetMapping("/findByEmailAndPhone/{email}/{phoneNo}")
    public Customer getCustomerByEmailAndPhoneNo(@PathVariable String email, @PathVariable String phoneNo){
        logger.debug("Email " + email + " phoneNo " + phoneNo);
        return service.getCustomerByEmailAndPhoneNo(email,phoneNo) ;
    }
}
