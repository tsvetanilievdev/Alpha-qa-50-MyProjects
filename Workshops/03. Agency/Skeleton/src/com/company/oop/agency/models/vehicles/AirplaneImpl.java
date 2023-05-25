package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Airplane;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.models.vehicles.enums.VehicleType;

public class AirplaneImpl extends VehicleBase implements Airplane, Vehicle {

    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

    private final int id;
    private boolean hasFreeFood;
    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(VehicleType.AIR, passengerCapacity, pricePerKilometer);
        this.id = id;
        this.hasFreeFood = hasFreeFood;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAsString() {
        return String.format("Airplane ----%nPassenger capacity: %s%nPrice per kilometer: %s%nVehicle type: %s%nHas free food: %s",
                super.getPassengerCapacity(),
                super.getPricePerKilometer(),
                super.getType(),
                hasFreeFood());
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        if(passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE){
            throw new IllegalArgumentException(String.format("The airplane cannot have less than %d passengers or more than %d passengers.", PRICE_MIN_VALUE, PRICE_MAX_VALUE));
        }
    }

    @Override
    protected void validatePricePerKilometer(double pricePerKilometer) {
        if(pricePerKilometer < PRICE_MIN_VALUE || pricePerKilometer > PRICE_MAX_VALUE){
            throw new IllegalArgumentException(String.format("The airplane price cannot be cheaper than %.2f or more expensive than %.2f",PRICE_MIN_VALUE, PRICE_MAX_VALUE));
        }
    }

    @Override
    public boolean hasFreeFood() {
        return hasFreeFood;
    }
}