package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.models.vehicles.enums.VehicleType;

public class TrainImpl extends VehicleBase implements Train, Vehicle {
    public static final int PASSENGER_MIN_VALUE = 30;
    public static final int PASSENGER_MAX_VALUE = 150;
    public static final int CARTS_MIN_VALUE = 1;
    public static final int CARTS_MAX_VALUE = 15;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

    private final int id;
    private int carts;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(VehicleType.LAND, passengerCapacity, pricePerKilometer);
        this.id = id;
        setCarts(carts);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public int getCarts() {
        return carts;
    }

    private void setCarts(int carts) {
        if (carts < CARTS_MIN_VALUE || carts > CARTS_MAX_VALUE) {
            throw new IllegalArgumentException(String.format("The train's carts must be between %d and %d", CARTS_MIN_VALUE, CARTS_MAX_VALUE));
        }
        this.carts = carts;
    }

    @Override
    public String getAsString() {
        return String.format("Train ----%nPassenger capacity: %s%nPrice per kilometer: %s%nVehicle type: %s%nCarts amount: %s",
                super.getPassengerCapacity(),
                super.getPricePerKilometer(),
                super.getType(),
                getCarts());
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(String.format("The train cannot have less than %d passengers or more than %d passengers.", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE));

        }
    }

    @Override
    protected void validatePricePerKilometer(double pricePerKilometer) {
        if (pricePerKilometer < PRICE_MIN_VALUE || pricePerKilometer > PRICE_MAX_VALUE) {
            throw new IllegalArgumentException(String.format("A train's ticket price cannot be cheaper than %.2f or more expensive than %.2f",
                    PRICE_MIN_VALUE,
                    PRICE_MAX_VALUE));
        }
    }
}