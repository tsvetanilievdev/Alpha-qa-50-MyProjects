package com.company.oop.cosmetics.models;

import com.company.oop.cosmetics.models.contracts.Product;
import com.company.oop.cosmetics.utils.ValidationHelpers;

public class ProductImpl implements Product {

    public static final int MIN_LENGTH_PRODUCT_NAME = 3;
    public static final int MAX_LENGTH_PRODUCT_NAME = 10;
    public static final int MIN_LENGTH_PRODUCT_BRAND = 2;
    public static final int MAX_LENGTH_PRODUCT_BRAND = 10;

    private String name;
    private String brand;
    private double price;
    private final GenderType gender;

    public ProductImpl(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        ValidationHelpers.validateIntegerRange("Product's name", name, MIN_LENGTH_PRODUCT_NAME, MAX_LENGTH_PRODUCT_NAME);
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    private void setBrand(String brand) {
        ValidationHelpers.validateIntegerRange("Product's brand", brand, MIN_LENGTH_PRODUCT_BRAND, MAX_LENGTH_PRODUCT_BRAND);
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        ValidationHelpers.validatePositiveNumber("Price", price);
        this.price = price;
    }

    public GenderType getGender() {
        return gender;
    }

    @Override
    public String print() {
        return String.format(
                "#%s %s%n" +
                        " #Price: $%.2f%n" +
                        " #Gender: %s%n",
                name,
                brand,
                price,
                gender);
    }

}
