package com.productshut.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Customer_TBL")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int customerId;

    @Column(name = "customerName", nullable=false)
    private String customerName;

    @Column(name = "emailId",nullable=false)
    private String emailId;

    @Column(name = "phoneNo", nullable=false)
    private String phoneNo;

    @Column(name = "address", nullable=false)
    private String address;
}
