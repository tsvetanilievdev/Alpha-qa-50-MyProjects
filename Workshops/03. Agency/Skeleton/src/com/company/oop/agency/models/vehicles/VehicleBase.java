package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.models.vehicles.enums.VehicleType;

public abstract class VehicleBase implements Vehicle {
    private final VehicleType type;
    private int passengerCapacity;
    private double pricePerKilometer;

    protected VehicleBase(VehicleType type, int passengerCapacity, double pricePerKilometer) {
        this.type = type;
        setPassengerCapacity(passengerCapacity);
        setPricePerKilometer(pricePerKilometer);
    }

    public VehicleType getType() {
        return type;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    private void setPassengerCapacity(int passengerCapacity) {
        validatePassengerCapacity(passengerCapacity);
        this.passengerCapacity = passengerCapacity;
    }

    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

    private void setPricePerKilometer(double pricePerKilometer) {
        validatePricePerKilometer(pricePerKilometer);
        this.pricePerKilometer = pricePerKilometer;
    }

    protected abstract void validatePassengerCapacity(int passengerCapacity);

    protected abstract void validatePricePerKilometer(double pricePerKilometer);

}
