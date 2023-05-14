package com.company.oop.cosmetics.models.cart;

import com.company.oop.cosmetics.models.products.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    
    private List<Product> productList;
    
    public ShoppingCart() {
        productList = new ArrayList<Product>();
    }
    
    public List<Product> getProductList() {
        return new ArrayList<>(productList);
    }
    
    public void addProduct(Product product) {
        this.productList.add(product);
    }
    
    public void removeProduct(Product product) {
        int index = this.productList.indexOf(product);
        while(index != -1) {
            this.productList.remove(product);
            index = this.productList.indexOf(product);
        }
    }
    
    public boolean containsProduct(Product product) {
        return this.productList.contains(product);
    }
    
    public double totalPrice() {
        double total = 0;

        for (Product product: this.productList) {
            total += product.getPrice();
        }
        return total;
    }
    
}
