package com.productshut.app.model;

import javax.persistence.*;

@Entity
public class product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int productId ;

    @Column(length = 20, nullable = false)
    private String productName ;

    @Column(length = 20, nullable = false)
    private String productType ;

    private int price ;

    private String productModel ;

    private boolean isBought ;

    private boolean isAvailable ;

    public product() {
    }

    public product(int productId, String productName, String productType, int price, String productModel, boolean isBought, boolean isAvailable) {
        this.productId = productId;
        this.productName = productName;
        this.productType = productType;
        this.price = price;
        this.productModel = productModel;
        this.isBought = isBought;
        this.isAvailable = isAvailable;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProductModel() {
        return productModel;
    }

    public void setProductModel(String productModel) {
        this.productModel = productModel;
    }

    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productType='" + productType + '\'' +
                ", price=" + price +
                ", productModel='" + productModel + '\'' +
                ", isBought=" + isBought +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
