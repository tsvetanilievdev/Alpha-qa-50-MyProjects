package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.models.vehicles.enums.VehicleType;

public class BusImpl extends VehicleBase implements Bus, Vehicle {

    public static final int PASSENGER_MIN_VALUE = 10;
    public static final int PASSENGER_MAX_VALUE = 50;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

    private final int id;

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(VehicleType.LAND, passengerCapacity, pricePerKilometer);
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAsString() {
        return String.format("Bus ----%nPassenger capacity: %s%nPrice per kilometer: %s%nVehicle type: %s",
                super.getPassengerCapacity(),
                super.getPricePerKilometer(),
                super.getType());
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(String.format("The bus cannot have less than %d passengers or more than %d passengers.", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE));

        }
    }

    @Override
    protected void validatePricePerKilometer(double pricePerKilometer) {
        if (pricePerKilometer < PRICE_MIN_VALUE || pricePerKilometer > PRICE_MAX_VALUE) {
            throw new IllegalArgumentException(String.format("the bus's ticket cannot be cheaper than %.2f or more expensive than %.2f", PRICE_MIN_VALUE, PRICE_MAX_VALUE));
        }
    }
}