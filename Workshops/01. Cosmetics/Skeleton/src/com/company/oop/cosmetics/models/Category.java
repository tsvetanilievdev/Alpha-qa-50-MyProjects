package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.products.Product;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private static final int MIN_CATEGORY_NAME_LENGTH = 2;
    private static final int MAX_CATEGORY_NAME_LENGTH = 15;

    private String name;
    private List<Product> productsList;
    
    public Category(String name) {
        setName(name);
        this.productsList = new ArrayList<>() {
        };
    }
    private String getName(){
        return this.name;
    }
    private void setName(String name){
        if(name == null) {
            throw new IllegalArgumentException("Name field cannot be null!");
        }else if(name.length() < MIN_CATEGORY_NAME_LENGTH || name.length() > MAX_CATEGORY_NAME_LENGTH){
            throw new IllegalArgumentException(String.format("Name field must be between %d and %d characters long!",MIN_CATEGORY_NAME_LENGTH, MAX_CATEGORY_NAME_LENGTH));
        }
        this.name = name;
    }
    
    public List<Product> getProducts() {
        return new ArrayList<>(this.productsList);
    }
    
    public void addProduct(Product product) {
        if(product == null) {
            throw new IllegalArgumentException("Product cannot be null!");
        }
        this.productsList.add(product);
    }
    
    public void removeProduct(Product product) {
        int index = this.productsList.indexOf(product);
        if(index == -1){
            throw new IllegalArgumentException("There is no such product in the category!");
        }
        this.productsList.remove(product);
    }
    
    public String print() {
        String result = String.format("#Category: %s",this.getName());

        if(this.productsList.size() > 0) {
            for (Product product: this.productsList) {
                result += product.print();
            }
        }else {
            result += String.format("%n #No product in this category");
        }
        return  result;
    }
    
}
