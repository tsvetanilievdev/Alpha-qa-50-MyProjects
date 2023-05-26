package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Train;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.models.vehicles.enums.VehicleType;

public class TrainImpl extends VehicleBase implements Train {
    public static final int PASSENGER_MIN_VALUE = 30;
    public static final int PASSENGER_MAX_VALUE = 150;
    public static final int CARTS_MIN_VALUE = 1;
    public static final int CARTS_MAX_VALUE = 15;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;

    private int carts;

    public TrainImpl(int id, int passengerCapacity, double pricePerKilometer, int carts) {
        super(id, passengerCapacity, pricePerKilometer);
        setCarts(carts);
    }
    @Override
    public VehicleType getType(){
        return VehicleType.LAND;
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
        return String.format("Train ----%nPassenger capacity: %s%nPrice per kilometer: %.2f%nVehicle type: %s%nCarts amount: %s%n",
                super.getPassengerCapacity(),
                super.getPricePerKilometer(),
                getType(),
                getCarts());
    }

    @Override
    protected void validatePassengerCapacity(int passengerCapacity) {
        if (passengerCapacity < PASSENGER_MIN_VALUE || passengerCapacity > PASSENGER_MAX_VALUE) {
            throw new IllegalArgumentException(String.format("A train cannot have less than %d passengers or more than %d passengers.", PASSENGER_MIN_VALUE, PASSENGER_MAX_VALUE));

        }
    }

}