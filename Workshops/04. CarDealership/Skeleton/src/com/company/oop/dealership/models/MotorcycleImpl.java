package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Motorcycle;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public class MotorcycleImpl extends VehicleBase implements Motorcycle {

    public static final int CATEGORY_LEN_MIN = 3;
    public static final int CATEGORY_LEN_MAX = 10;
    private static final String CATEGORY_LEN_ERR = format(
            "Category must be between %d and %d characters long!",
            CATEGORY_LEN_MIN,
            CATEGORY_LEN_MAX);

    private final int wheels = 2;
    private String category;

    public MotorcycleImpl(String make, String model, double price, String category) {
        super(make, model, price);
        setCategory(category);
    }

    @Override
    public int getWheels() {
        return wheels;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.MOTORCYCLE;
    }

    private void setCategory(String category) {
        validateCategory(category);
        this.category = category;
    }

    private void validateCategory(String category) {
        ValidationHelpers.validateIntRange(category.length(), CATEGORY_LEN_MIN, CATEGORY_LEN_MAX, CATEGORY_LEN_ERR);
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return String.format("Motorcycle:%n%sCategory: %s%n%s",
                super.toString(),
                getCategory(),
                super.printComments());
    }
}
