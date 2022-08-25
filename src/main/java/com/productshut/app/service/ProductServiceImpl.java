package com.productshut.app.service;

import com.productshut.app.model.Product;
import com.productshut.app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repository;

    // take only one product
    public Product saveProduct(Product product) {

        return repository.save(product);

    }

    // take list of products
    public List<Product> saveProducts(List<Product> products) {

        return repository.saveAll(products);
    }

    public List<Product> getProducts(){
        return repository.findAll() ;
    }

    public Product getProductById(int id){

        return repository.findById(id).orElse(null) ;
    }

    public Product getProductByName(String name){

        return repository.findByProductName(name) ;
    }

    public String deleteProduct(int id){
        repository.deleteById(id);
        return "Product removed !!" + id ;
    }

    public Product updateProduct(Product product){
        Product existingProduct = repository.findById(product.getProductId()).orElse(null) ;
        assert existingProduct != null;
        existingProduct.setProductName(product.getProductName());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());

        return repository.save(existingProduct) ;

    }
}
