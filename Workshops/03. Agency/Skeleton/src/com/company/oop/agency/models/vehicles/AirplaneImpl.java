package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Airplane;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.models.vehicles.enums.VehicleType;

public class AirplaneImpl extends VehicleBase implements Airplane {

    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

    private boolean hasFreeFood;

    public AirplaneImpl(int id, int passengerCapacity, double pricePerKilometer, boolean hasFreeFood) {
        super(id, passengerCapacity, pricePerKilometer);
        this.hasFreeFood = hasFreeFood;
    }
    @Override
    public VehicleType getType(){
        return VehicleType.AIR;
    }
    @Override
    public boolean hasFreeFood() {
        return hasFreeFood;
    }

    @Override
    public String getAsString() {
        return String.format("Airplane ----%nPassenger capacity: %s%nPrice per kilometer: %.2f%nVehicle type: %s%nHas free food: %s%n",
                super.getPassengerCapacity(),
                super.getPricePerKilometer(),
                getType(),
                hasFreeFood());
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(String.format("An airplane cannot have less than %d passengers or more than %d passengers.", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE));
        }
    }

}