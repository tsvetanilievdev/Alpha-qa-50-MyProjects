package com.company.oop.agency;

import com.company.oop.agency.core.AgencyEngineImpl;
import com.company.oop.agency.models.vehicles.BusImpl;
import com.company.oop.agency.models.vehicles.VehicleBase;

public class Startup {

    public static void main(String[] args) {
        AgencyEngineImpl engine = new AgencyEngineImpl();
        engine.start();
    }
}
