package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {
    private int id;
    private double costs;
    private Journey journey;

    public TicketImpl(int id, Journey journey, double costs) {
        this.id = id;
        this.journey = journey;
        setCosts(costs);
    }

    private void setCosts(double costs) {
        if (costs < 0) {
            throw new InvalidUserInputException(String.format("Value of 'costs' must be a positive number. Actual value: %.2f",costs));
        }
        this.costs = costs;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public String getAsString() {
        return String.format("Ticket ----%nDestination: %s%nPrice: %.2f%n",
                getJourney().getDestination(), calculatePrice());
    }

    @Override
    public Journey getJourney() {
        return journey;
    }

    @Override
    public double calculatePrice() {
        return getJourney().calculateTravelCosts() * getAdministrativeCosts();
    }

    @Override
    public double getAdministrativeCosts() {
        return costs;
    }
}
