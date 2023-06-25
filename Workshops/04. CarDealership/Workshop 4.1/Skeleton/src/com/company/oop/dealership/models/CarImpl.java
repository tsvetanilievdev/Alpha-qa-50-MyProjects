package com.company.oop.dealership.models;

import com.company.oop.dealership.models.contracts.Car;
import com.company.oop.dealership.models.enums.VehicleType;
import com.company.oop.dealership.utils.ValidationHelpers;

import static java.lang.String.format;

public class CarImpl extends VehicleBase implements Car {
    public static final int CAR_SEATS_MIN = 1;
    public static final int CAR_SEATS_MAX = 10;
    private static final String CAR_SEATS_ERR = format(
            "Seats must be between %d and %d!",
            CAR_SEATS_MIN,
            CAR_SEATS_MAX);

    private final int wheels = 4;
    private int seats;

    public CarImpl(String make, String model, double price, int seats) {
        super(make, model, price);
        setSeats(seats);
    }

    @Override
    public int getWheels() {
        return wheels;
    }

    @Override
    public VehicleType getType() {
        return VehicleType.CAR;
    }

    @Override
    public int getSeats() {
        return seats;
    }

    private void setSeats(int seats) {
        validateSeats(seats);
        this.seats = seats;
    }

    private void validateSeats(int seats) {
        ValidationHelpers.validateIntRange(seats, CAR_SEATS_MIN, CAR_SEATS_MAX, CAR_SEATS_ERR);
    }

    @Override
    public String toString() {

        return String.format("Car:%n%sSeats: %d%n%s",
                super.toString(),
                getSeats(),
                super.printComments());
    }
}
