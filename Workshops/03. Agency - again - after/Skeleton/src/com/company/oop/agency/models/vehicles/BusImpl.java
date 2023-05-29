package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;

public class BusImpl extends VehicleBase implements Bus {

    public static final int PASSENGER_MIN_VALUE = 10;
    public static final int PASSENGER_MAX_VALUE = 50;
    private static final String PASSENGER_ERROR_MESSAGE = String.format("A bus cannot have less than %d passengers or more than %d passengers.",
            PASSENGER_MIN_VALUE,
            PASSENGER_MAX_VALUE);

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(id, passengerCapacity, pricePerKilometer);
    }

    @Override
    public VehicleType getType() {
        return VehicleType.LAND;
    }
    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(PASSENGER_ERROR_MESSAGE);
        }
    }

    @Override
    public String getAsString() {
        return String.format("Bus ----%n%s",
                super.getAsString());
    }
}