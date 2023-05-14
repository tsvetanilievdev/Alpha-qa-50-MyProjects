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
        return price;
    }
    private String getName() {
        return name;
    }
    private String getBrand() {
        return brand;
    }
    private GenderType getGender() {
        return gender;
    }
    private void setName(String name) {
        if(name == null) {
            throw new IllegalArgumentException("Name field cannot be null!");
        }else if(name.length() < MIN_PRODUCT_NAME_LENGTH || name.length() > MAX_PRODUCT_NAME_LENGTH){
            throw new IllegalArgumentException(String.format("Name field must be between %d and %d characters long!",MIN_PRODUCT_NAME_LENGTH, MAX_PRODUCT_NAME_LENGTH));
        }
        this.name = name;
    }

    private void setBrand(String brand) {
        if(brand == null) {
            throw new IllegalArgumentException("Name field cannot be null!");
        }else if(brand.length() < MIN_PRODUCT_BRAND_LENGTH || brand.length() > MAX_PRODUCT_BRAND_LENGTH){
            throw new IllegalArgumentException(String.format("The Brand field must be between %d and %d characters long!", MIN_PRODUCT_BRAND_LENGTH, MAX_PRODUCT_BRAND_LENGTH) );
        }
        this.brand = brand;
    }
    private void setPrice(double price){
        if(price < 0){
            throw  new IllegalArgumentException("The price cannot be negative number!");
        }
        this.price = price;
    }

    public String print() {
        return String.format("%n #%s %s%n #Price: %.2f%n #Gender: %s%n ===", getName(), getBrand(), getPrice(), getGender());
    }
}
