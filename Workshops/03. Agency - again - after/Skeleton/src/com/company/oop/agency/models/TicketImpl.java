package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {
    private final int id;
    private Journey journey;
    private double costs;

    public TicketImpl(int id, Journey journey, double costs) {
        this.id = id;
        this.journey = journey;
        setAdministrativeCosts(costs);
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAsString() {
        return String.format("Ticket ----%nDestination: %s%nPrice: %.2f%n",
                journey.getDestination(),
                calculatePrice());
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

    @Override
    public double calculatePrice() {
        return getAdministrativeCosts() * getJourney().calculateTravelCosts();
    }

    @Override
    public double getAdministrativeCosts() {
        return costs;
    }

    private void setAdministrativeCosts(double costs){
        if(costs < 0){
            throw new InvalidUserInputException(String.format("Value of 'costs' must be a positive number. Actual value: %.2f.", costs));
        }
        this.costs = costs;
    }
}
