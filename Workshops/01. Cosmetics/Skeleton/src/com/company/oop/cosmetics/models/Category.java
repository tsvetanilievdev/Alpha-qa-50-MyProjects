package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Category {
    
    private String name;
    private List<Product> products;
    
    public Category(String name) {
        this.name = name;
        this.products = new ArrayList<Product>() {
        };
    }
    
    public List<Product> getProducts() {
        return this.products;
    }
    
    public void addProduct(Product product) {
        this.products.add(product);
    }
    
    public void removeProduct(Product product) {
        int index = this.products.indexOf(product);
        if(index == -1){
            throw new IllegalArgumentException("There is no such product in the category!");
        }

        while(index != -1){
            this.products.remove(product);
            index = this.products.indexOf(product);
        }
    }
    
    public String print() {
        String result = String.format("#Category: %s",this.name);

        if(this.products.size() > 0) {
            for (Product product: this.products) {
                result += product.print();
            }
        }else {
            result += String.format("%n #No product in this category");
        }
        return  result;
    }
    
}
