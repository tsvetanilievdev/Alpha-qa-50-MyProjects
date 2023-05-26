package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.models.vehicles.enums.VehicleType;

public class BusImpl extends VehicleBase implements Bus {

    public static final int PASSENGER_MIN_VALUE = 10;
    public static final int PASSENGER_MAX_VALUE = 50;

    public BusImpl(int id, int passengerCapacity, double pricePerKilometer) {
        super(id, passengerCapacity, pricePerKilometer);
    }
    @Override
    public VehicleType getType(){
        return VehicleType.LAND;
    }

    @Override
    public String getAsString() {
        return String.format("Bus ----%n%s", super.getAsString());
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(String.format("A bus cannot have less than %d passengers or more than %d passengers.", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE));
        }
    }

}