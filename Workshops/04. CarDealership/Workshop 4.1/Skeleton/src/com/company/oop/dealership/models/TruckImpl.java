package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Comment;
import com.company.oop.dealership.models.contracts.Truck;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public class TruckImpl extends VehicleBase implements Truck {
    private static final int WEIGHT_CAP_MIN = 1;
    private static final int WEIGHT_CAP_MAX = 100;
    private static final String WEIGHT_CAP_ERR = format(
            "Weight capacity must be between %d and %d!",
            WEIGHT_CAP_MIN,
            WEIGHT_CAP_MAX);
    private final int wheels = 8;
    private int weightCapacity;

    public TruckImpl(String make, String model, double price, int weightCapacity) {
        super(make, model, price);
        setCapacity(weightCapacity);
    }

    @Override
    public int getWheels() {
        return wheels;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.TRUCK;
    }

    private void setCapacity(int weightCapacity) {
        validateCapacity(weightCapacity);
        this.weightCapacity = weightCapacity;
    }

    private void validateCapacity(int weightCapacity) {
        ValidationHelpers.validateIntRange(weightCapacity, WEIGHT_CAP_MIN, WEIGHT_CAP_MAX, WEIGHT_CAP_ERR);
    }

    @Override
    public int getWeightCapacity() {
        return weightCapacity;
    }

    @Override
    public String toString() {
        return String.format("Truck:%n%sWeight Capacity: %dt%n%s",
                super.toString(),
                getWeightCapacity(),
                super.printComments());
    }
}
