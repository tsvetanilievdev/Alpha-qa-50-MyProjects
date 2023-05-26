package com.company.oop.agency.models.vehicles;

import com.company.oop.agency.models.vehicles.contracts.Airplane;
import com.company.oop.agency.models.vehicles.contracts.Vehicle;
import com.company.oop.agency.models.vehicles.enums.VehicleType;

public class AirplaneImpl extends VehicleBase implements Airplane {

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
        return String.format("Airplane ----%n%sHas free food: %s%n",
                super.getAsString(),
                hasFreeFood());
    }

}