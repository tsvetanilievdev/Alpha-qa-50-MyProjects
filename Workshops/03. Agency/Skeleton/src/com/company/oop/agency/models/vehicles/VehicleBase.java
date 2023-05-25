package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.models.vehicles.enums.VehicleType;

public abstract class VehicleBase {
    private static int id;

    static  {
        id = 0;
    }
    private final VehicleType type;
    private int passengerCapacity;
    private double pricePerKilometer;
    protected VehicleBase(VehicleType type, int passengerCapacity,double pricePerKilometer) {
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

    public double getPricePerKilometer() {
        return pricePerKilometer;
    }

    public int getId(){
        return this.id;
    }

    private void setPassengerCapacity(int passengerCapacity) {
        validatePassengerCapacity(passengerCapacity);
        this.passengerCapacity = passengerCapacity;
    }
    private void setPricePerKilometer(double pricePerKilometer){
        validatePricePerKilometer(pricePerKilometer);
        this.pricePerKilometer = pricePerKilometer;
    }

    protected abstract void validatePassengerCapacity(int passengerCapacity);
    protected abstract void validatePricePerKilometer(double pricePerKilometer);

}
