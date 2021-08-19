package com.kodigo.interfaces;

import com.kodigo.models.Flights;
import org.apache.http.util.Args;

public interface FlightMenu {
    // Show flight Menu options
    void flightMenu();
    //Show flights in the shell
    void showFlight(Flights flights);
    //Add new flight from the shell
    void addNewFlightFromShell();
    //Add new flights from excel file
    void addNewFlightFromExcel();
    void generateReports();
}
