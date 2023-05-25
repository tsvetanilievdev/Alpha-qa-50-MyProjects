package com.company.oop.agency.models.vehicles.contracts;

public interface Airplane extends Vehicle {
    public static final int PASSENGER_MIN_VALUE = 1;
    public static final int PASSENGER_MAX_VALUE = 800;
    public static final double PRICE_MIN_VALUE = 0.1;
    public static final double PRICE_MAX_VALUE = 2.5;
    boolean hasFreeFood();

}