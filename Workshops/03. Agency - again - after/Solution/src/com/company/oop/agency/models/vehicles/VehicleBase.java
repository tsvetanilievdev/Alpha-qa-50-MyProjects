package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.utils.ValidationHelper;

public abstract class VehicleBase implements Vehicle {
    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;
    public static final String ERROR_MESSAGE = "A %s with less than %d passengers or more than %d passengers cannot exist!";
    public static final String INVALID_PASSENGER_CAPACITY = String.format(
            ERROR_MESSAGE,
            "vehicle",
            PASSENGER_MIN_VALUE,
            PASSENGER_MAX_VALUE);
    private static final double PRICE_MIN_VALUE = 0.1;
    private static final double PRICE_MAX_VALUE = 2.5;
    public static final String INVALID_PRICE_PER_KILOMETER = String.format(
            "A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!",
            PRICE_MIN_VALUE,
            PRICE_MAX_VALUE);

    private final int id;
    private int passengerCapacity;
    private double pricePerKilometer;

    protected VehicleBase(int id, int passengerCapacity, double pricePerKilometer) {
        this.id = id;
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    @Override
    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

    private void setPassengerCapacity(int passengerCapacity) {
        validatePassengerCapacity(passengerCapacity);
        this.passengerCapacity = passengerCapacity;
    }

    void validatePassengerCapacity(int passengerCapacity) {
        ValidationHelper.validateValueInRange(
                passengerCapacity,
                PASSENGER_MIN_VALUE,
                PASSENGER_MAX_VALUE,
                INVALID_PASSENGER_CAPACITY);
    }

    private void setPricePerKilometer(double pricePerKilometer) {
        validatePricePerKilometer(pricePerKilometer);
        this.pricePerKilometer = pricePerKilometer;
    }

    void validatePricePerKilometer(double pricePerKilometer) {
        ValidationHelper.validateValueInRange(
                pricePerKilometer,
                PRICE_MIN_VALUE,
                PRICE_MAX_VALUE,
                INVALID_PRICE_PER_KILOMETER);
    }

    @Override
    public String getAsString() {
        String className = String.format("%s", getClass().getSimpleName().replace("Impl", ""));
        return String.format("%s ----\n" +
                        "Passenger capacity: %d\n" +
                        "Price per kilometer: %.2f\n" +
                        "Vehicle type: %s\n",
                className,
                passengerCapacity,
                pricePerKilometer,
                getType());
    }
}