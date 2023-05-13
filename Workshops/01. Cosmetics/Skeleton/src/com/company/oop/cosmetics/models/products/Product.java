package com.company.oop.cosmetics.models.products;

import com.company.oop.cosmetics.models.common.GenderType;

public class Product {
    
    private double price;
    private String name;
    private String brand;
    private GenderType gender;
    
    public Product(String name, String brand, double price, GenderType gender) {
        // finish the constructor and validate data
    //    setPrice(price);
    }
    
    public String print() {
        return "";
        // Format:
        //" #[Name] [Brand]
        // #Price: [Price]
        // #Gender: [Gender]
        // ==="
    }
    
}
