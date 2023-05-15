package com.company.oop.cosmetics.models.products;

import com.company.oop.cosmetics.models.common.GenderType;

public class Product {
    private static final int MIN_PRODUCT_NAME_LENGTH = 3;
    private static final int MAX_PRODUCT_NAME_LENGTH = 10;
    public static final String PRODUCT_NAME_LENGTH_ERROR = String.format("Name field must be between %d and %d characters long!", MIN_PRODUCT_NAME_LENGTH, MAX_PRODUCT_NAME_LENGTH);
    private static final int MIN_PRODUCT_BRAND_LENGTH = 2;
    private static final int MAX_PRODUCT_BRAND_LENGTH = 10;
    public static final String PRODUCT_BRAND_LENGTH_ERROR = String.format("The Brand field must be between %d and %d characters long!", MIN_PRODUCT_BRAND_LENGTH, MAX_PRODUCT_BRAND_LENGTH);

    private double price;
    private String name;
    private String brand;
    private GenderType gender;
    
    public Product(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        setGender(gender);
    }

    public double getPrice () {
        return price;
    }

    private void setName(String name) {
        if(name == null) {
            throw new IllegalArgumentException("Name field cannot be null!");
        }else if(name.length() < MIN_PRODUCT_NAME_LENGTH || name.length() > MAX_PRODUCT_NAME_LENGTH){
            throw new IllegalArgumentException(PRODUCT_NAME_LENGTH_ERROR);
        }
        this.name = name;
    }

    private void setBrand(String brand) {
        if(brand == null) {
            throw new IllegalArgumentException("Brand field cannot be null!");
        }else if(brand.length() < MIN_PRODUCT_BRAND_LENGTH || brand.length() > MAX_PRODUCT_BRAND_LENGTH){
            throw new IllegalArgumentException(PRODUCT_BRAND_LENGTH_ERROR);
        }
        this.brand = brand;
    }
    private void setPrice(double price){
        if(price < 0){
            throw  new IllegalArgumentException("The price cannot be negative number!");
        }
        this.price = price;
    }
    private void setGender(GenderType gender){
        if(gender == null) {
            throw new IllegalArgumentException("Gender field cannot be null!");
        }
        if(!gender.equals(GenderType.MEN) && !gender.equals(GenderType.WOMAN) && !gender.equals(GenderType.UNISEX)){
            throw new IllegalArgumentException("Gender must be MEN, WOMAN or UNISEX");
        }
        this.gender = gender;
    }

    public String print() {
        return String.format("%n #%s %s%n #Price: %.2f%n #Gender: %s%n ===",
                name, brand, price, gender);
    }
}
