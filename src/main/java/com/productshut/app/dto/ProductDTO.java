package com.productshut.app.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private int productId ;

    private String productName ;

    private int quantity ;

    private double price ;
}
