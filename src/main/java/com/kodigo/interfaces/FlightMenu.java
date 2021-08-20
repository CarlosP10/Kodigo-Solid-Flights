package com.kodigo.interfaces;

import com.kodigo.models.Flights;

public interface FlightMenu {
    // Show flight Menu options
    void flightMenu();
    //Show flights in the shell
    String showFlight(Flights flights);
    //Add new flight from the shell
    void addNewFlightFromShell();
    //Add new flights from excel file
    void addNewFlightFromExcel();
    void generateReports();
}
