package com.kodigo.interfaces;

import com.kodigo.models.Flights;

public interface FlightManager {
    // Show menu flight manager options


    void managerMenu(int flightId);

    //Update flight by id
    void updateFlight(Flights flight);
    //Cancel flight by id
    void cancelFlight(Flights flight);
    //Not to sure about this method if should be a method or just a boolean in Flight class?
    void landedFlight(Flights flight);
}
