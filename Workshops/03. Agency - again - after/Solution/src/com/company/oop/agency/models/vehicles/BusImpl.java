package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Bus;
import com.company.oop.agency.utils.ValidationHelper;

public class BusImpl extends VehicleBase implements Bus {

    private static final int PASSENGER_MIN_VALUE = 10;
    private static final int PASSENGER_MAX_VALUE = 50;
    private static final String PASSENGER_ERROR_MESSAGE = String.format(
            "A bus cannot have less than %d passengers or more than %d passengers.",
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
    void validatePassengerCapacity(int passengerCapacity) {
        ValidationHelper.validateValueInRange(
                passengerCapacity,
                PASSENGER_MIN_VALUE,
                PASSENGER_MAX_VALUE,
                PASSENGER_ERROR_MESSAGE);
    }
}