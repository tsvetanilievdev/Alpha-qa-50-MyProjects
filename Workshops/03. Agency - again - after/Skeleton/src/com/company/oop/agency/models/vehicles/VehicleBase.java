package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Vehicle;

public abstract class VehicleBase implements Vehicle {

    private static final int PASSENGER_MIN_VALUE = 1;
    private static final int PASSENGER_MAX_VALUE = 800;
    private static final String PASSENGER_ERROR_MESSAGE = String.format("A vehicle with less than %d passengers or more than %d passengers cannot exist!",
            PASSENGER_MIN_VALUE,
            PASSENGER_MAX_VALUE);
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;
    private static final String PRICE_ERROR_MESSAGE = String.format("A vehicle with a price per kilometer lower than $%.2f or higher than $%.2f cannot exist!",
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

    private void setPricePerKilometer(double pricePerKilometer) {
        validatePricePerKilometer(pricePerKilometer);
        this.pricePerKilometer = pricePerKilometer;
    }

    protected void validatePassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(PASSENGER_ERROR_MESSAGE);
        }
    }

    protected void validatePricePerKilometer(double pricePerKilometer) {
        if (pricePerKilometer < PRICE_MIN_VALUE || pricePerKilometer > PRICE_MAX_VALUE) {
            throw new IllegalArgumentException(PRICE_ERROR_MESSAGE);
        }
    }

    @Override
    public String getAsString() {
        return String.format("Passenger capacity: %d%nPrice per kilometer: %.2f%nVehicle type: %s%n",
                getPassengerCapacity(),
                getPricePerKilometer(),
                getType());
    }

}
