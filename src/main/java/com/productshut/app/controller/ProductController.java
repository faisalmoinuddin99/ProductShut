package com.productshut.app.controller;

import com.productshut.app.dto.ProductDTO;
import com.productshut.app.model.Product;
import com.productshut.app.service.ProductServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class ProductController {

    @Autowired
    ProductServiceImpl service;

    @Autowired
    ModelMapper modelMapper ;

    @PostMapping("/addProduct")
    public Product addProduct(@RequestBody Product product) {
        return service.saveProduct(product);
    }

    @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping(path = "/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping(path = "/productById/{id}")
    public ResponseEntity<ProductDTO> findProductById(@PathVariable int id) {
        Product product = service.getProductById(id);
        ProductDTO productDTO = modelMapper.map(product,ProductDTO.class) ;

        return new ResponseEntity<>(productDTO, HttpStatus.OK) ;
    }

    @GetMapping(path = "/productByName/{name}")
    public ResponseEntity<ProductDTO> findProductByName(@PathVariable String name) {
        Product product = service.getProductByName(name);
        ProductDTO productDTO = modelMapper.map(product,ProductDTO.class) ;

        if(!Objects.equals(name, product.getProductName())){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build() ; // need to fix this later
        }else{
            return new ResponseEntity<>(productDTO,HttpStatus.OK) ;
        }

    }

    @PutMapping("/update")
    public Product updateProducts(@RequestBody Product products) {
        return service.updateProduct(products) ;
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id) ;
    }

}
