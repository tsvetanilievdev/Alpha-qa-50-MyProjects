package com.company.oop.agency.models;

import com.company.oop.agency.exceptions.InvalidUserInputException;
import com.company.oop.agency.models.contracts.Journey;
import com.company.oop.agency.models.contracts.Ticket;

public class TicketImpl implements Ticket {

    public static final int MIN_ADMINISTRATIVE_COSTS = 1;
    private int id;
    private Journey journey;
    private double administrativeCosts;

    public TicketImpl(int id, Journey journey, double costs) {
        setId(id);
        setJourney(journey);
        setAdministrativeCosts(costs);
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public Journey getJourney() {
        return journey;
    }

    private void setJourney(Journey journey) {
        this.journey = journey;
    }

    @Override
    public double calculatePrice() {
        return administrativeCosts * journey.calculateTravelCosts();
    }

    public double getAdministrativeCosts() {
        return administrativeCosts;
    }

    public void setAdministrativeCosts(double administrativeCosts) {
        validateAdministrativeCosts(administrativeCosts);
        this.administrativeCosts = administrativeCosts;
    }

    private void validateAdministrativeCosts(double administrativeCosts) {
        if (administrativeCosts < MIN_ADMINISTRATIVE_COSTS) {
            throw new InvalidUserInputException(String.format("Value of 'costs' must be a positive number. Actual value: %.2f.",
                    administrativeCosts));
        }
    }

    @Override
    public String getAsString() {
        return String.format(
                "Ticket ----\n" +
                        "Destination: %s\n" +
                        "Price: %.2f\n",
                journey.getDestination(),
                calculatePrice());
    }
}