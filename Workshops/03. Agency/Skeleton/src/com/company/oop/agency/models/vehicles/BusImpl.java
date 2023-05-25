package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.models.vehicles.enums.VehicleType;

public class BusImpl extends VehicleBase implements Bus {

    public static final int PASSENGER_MIN_VALUE = 10;
    public static final int PASSENGER_MAX_VALUE = 50;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

    private int id;
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
        if(passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE){
            throw new IllegalArgumentException("A Bus cannot have less than 30 passengers or more than 150 passengers.");
        }
    }

    @Override
    protected void validatePricePerKilometer(double pricePerKilometer) {
        if(pricePerKilometer < PRICE_MIN_VALUE || pricePerKilometer > PRICE_MAX_VALUE){
            throw new IllegalArgumentException(String.format("A Bus cannot be cheaper than %.2f or more expensive than %.2f",PRICE_MIN_VALUE, PRICE_MAX_VALUE));
        }
    }
}