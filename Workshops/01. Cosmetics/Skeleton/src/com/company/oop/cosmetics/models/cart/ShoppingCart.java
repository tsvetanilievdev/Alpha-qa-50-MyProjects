package com.company.oop.cosmetics.models.cart;

import com.company.oop.cosmetics.models.products.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    
    private List<Product> productList;
    
    public ShoppingCart() {
    }
    
    public List<Product> getProductList() {
        return new ArrayList<>(productList);
    }
    
    public void addProduct(Product product) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
    public void removeProduct(Product product) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
    public boolean containsProduct(Product product) {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
    public double totalPrice() {
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
