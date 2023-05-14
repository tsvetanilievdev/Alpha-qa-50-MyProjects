package com.company.oop.cosmetics.models.products;

import com.company.oop.cosmetics.models.common.GenderType;

public class Product {
    
    private double price;
    private String name;
    private String brand;
    private GenderType gender;
    
    public Product(String name, String brand, double price, GenderType gender) {
        if(name.length() < 3 && name.length() > 10){
            throw new IllegalArgumentException("The must be between 3 and 10 characters long!");
        }
        this.name = name;
        if(brand.length() < 2 && brand.length() > 10){
            throw new IllegalArgumentException("The must be between 2 and 10 characters long!");
        }
        this.brand = brand;
        if(price < 0){
            throw  new IllegalArgumentException("The price cannot be negative number!");
        }
        this.price = price;
        this.gender = gender;
    }
    
    public String print() {
        return String.format(" #%s %s%n#Price: %.2f%nGender: %s%n===", this.name, this.brand, this.price, this.gender);
    }

    public double getPrice () {
        return this.price;
    }
}
