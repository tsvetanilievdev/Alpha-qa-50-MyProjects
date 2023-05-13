package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.products.Product;

import java.util.List;

public class Category {
    
    private String name;
    private List<Product> products;
    
    public Category(String name) {
    }
    
    public List<Product> getProducts() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
    public void addProduct(Product product) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
    public void removeProduct(Product product) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
    public String print() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
