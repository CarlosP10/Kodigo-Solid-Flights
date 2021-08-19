package com.kodigo.interfaces;

import com.kodigo.models.Flights;

public interface FlightManager {
    //Update flight by id
    public void updateFlight(String id);
    //Cancel flight by id
    public void cancelFlight(String id);
    //Not to sure about this method if should be a method or just a boolean in Flight class?
    public void landedFlight(String id);
}
