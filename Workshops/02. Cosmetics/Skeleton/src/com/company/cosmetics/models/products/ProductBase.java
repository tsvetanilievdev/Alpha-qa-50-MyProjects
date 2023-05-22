package com.company.cosmetics.models.products;

import com.company.cosmetics.models.contracts.Product;
import com.company.cosmetics.models.common.GenderType;


public class ProductBase implements Product {
    public static final int MIN_PROPERTY_NAME_LENGTH = 3;
    public static final int MIN_PROPERTY_BRAND_LENGTH = 2;
    public static final int MAX_PROPERTY_LENGTH = 10;
    private String name;
    private String brand;
    private double price;
    private GenderType gender;

    protected ProductBase(String name, String brand, double price, GenderType gender) {
        setName(name);
        setBrand(brand);
        setPrice(price);
        this.gender = gender;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        validateForNull("name",name);
        validateLength("name", name, MIN_PROPERTY_NAME_LENGTH, MAX_PROPERTY_LENGTH);
        this.name = name;
    }

    @Override
    public String getBrand() {
        return this.brand;
    }

    private void setBrand(String brand) {
        validateForNull("brand",brand);
        validateLength("brand", brand, MIN_PROPERTY_BRAND_LENGTH, MAX_PROPERTY_LENGTH);
        this.brand = brand;
    }

    @Override
    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        validateNegativeValue("price", price);
        this.price = price;
    }

    @Override
    public GenderType getGender() {
        return this.gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    @Override
    public String print() {
        return String.format("#%s %s%n #Price: $%.2f%n #Gender: %s%n", getName(), getBrand(), getPrice(),getGender());
    }

    void validateLength(String property, String propertyText, int MIN_PROPERTY_LENGTH, int MAX_PROPERTY_LENGTH) {
        if (propertyText.length() < MIN_PROPERTY_LENGTH || propertyText.length() > MAX_PROPERTY_LENGTH) {
            throw new IllegalArgumentException(String.format("The %s must be between %d and %d characters long!",
                    property,
                    MIN_PROPERTY_LENGTH,
                    MAX_PROPERTY_LENGTH));
        }
    }
    void validateForNull(String property, String propertyText){
        if(propertyText == null) {
            throw new IllegalArgumentException(String.format("The %s field cannot be empty or null",
                    property));
        }
    }
    void validateNegativeValue(String property, double price) {
        if(price < 0) {
            throw new IllegalArgumentException(String.format("The %s cannot be negative!", property));
        }
    }
}
