package com.company.cosmetics.models.contracts;

import java.util.List;

public interface ShoppingCart {
    
    public List<Product> getProductList();
    
    public void addProduct(Product product);
    
    public void removeProduct(Product product);
    
    public boolean containsProduct(Product product);
    
    public double totalPrice();
    
}
