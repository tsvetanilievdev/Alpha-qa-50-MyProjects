package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.models.vehicles.enums.VehicleType;

public abstract class VehicleBase implements Vehicle {
    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

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

    private void setPassengerCapacity(int passengerCapacity) {
        validatePassengerCapacity(passengerCapacity);
        this.passengerCapacity = passengerCapacity;
    }
    @Override
    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

    private void setPricePerKilometer(double pricePerKilometer) {
        validatePricePerKilometer(pricePerKilometer);
        this.pricePerKilometer = pricePerKilometer;
    }

    //TO DO...
    protected void validatePassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(String.format("An %s cannot have less than %d passengers or more than %d passengers.",
                    getClass().getSimpleName(),
                    PASSENGER_MIN_VALUE,
                    PASSENGER_MAX_VALUE));
        }
    }

    protected void validatePricePerKilometer(double pricePerKilometer) {
        if (pricePerKilometer < PRICE_MIN_VALUE || pricePerKilometer > PRICE_MAX_VALUE) {
            throw new IllegalArgumentException(String.format("A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!",
                    PRICE_MIN_VALUE,
                    PRICE_MAX_VALUE));
        }
    }

    @Override
    public String getAsString() {
        return String.format("Passenger capacity: %s%nPrice per kilometer: %.2f%nVehicle type: %s%n",
                getPassengerCapacity(),
                getPricePerKilometer(),
                getType());
    };

}
