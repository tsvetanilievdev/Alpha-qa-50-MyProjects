package com.company.oop.cosmetics.models.products;

import com.company.oop.cosmetics.models.common.GenderType;

public class Product {
    private static final int MIN_PRODUCT_NAME_LENGTH = 3;
    private static final int MAX_PRODUCT_NAME_LENGTH = 10;
    private static final int MIN_PRODUCT_BRAND_LENGTH = 2;
    private static final int MAX_PRODUCT_BRAND_LENGTH = 10;

    private double price;
    private String name;
    private String brand;
    private GenderType gender;
    
    public Product(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender = gender;
    }

    public double getPrice () {
        return this.price;
    }
    private void setName(String name) {
        if(name == null) {
            throw new IllegalArgumentException("Name field cannot be null!");
        }else if(name.length() < MIN_PRODUCT_NAME_LENGTH || name.length() > MAX_PRODUCT_NAME_LENGTH){
            throw new IllegalArgumentException(String.format("Name field must be between %d and %d characters long!",MIN_PRODUCT_NAME_LENGTH, MAX_PRODUCT_NAME_LENGTH));
        }
    }

    private void setBrand(String brand) {
        if(brand == null) {
            throw new IllegalArgumentException("Name field cannot be null!");
        }else if(brand.length() < MIN_PRODUCT_BRAND_LENGTH || brand.length() > MAX_PRODUCT_BRAND_LENGTH){
            throw new IllegalArgumentException(String.format("The Brand field must be between %d and %d characters long!", MIN_PRODUCT_BRAND_LENGTH, MAX_PRODUCT_BRAND_LENGTH) );
        }
    }
    private void setPrice(double price){
        if(price < 0.00){
            throw  new IllegalArgumentException("The price cannot be negative number!");
        }
    }

    public String print() {
        return String.format(" #%s %s%n#Price: %.2f%nGender: %s%n===", this.name, this.brand, this.price, this.gender);
    }
}
