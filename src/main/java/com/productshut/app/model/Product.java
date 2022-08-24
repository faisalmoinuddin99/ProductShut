package com.productshut.app.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Product_TBL")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId ;

    @Column(length = 20, nullable = false)
    private String productName ;

    private int quantity ;
    private double price ;



}
