package com.kodigo.interfaces;

import com.kodigo.models.Flights;
import org.apache.http.util.Args;

public interface FlightMenu {
    //Show flights in the shell
    static void showFlights(){}
    //Add new flight from the shell
    static void addNewFlightFromShell(Flights flight){}
    //Add new flights from excel file
    static void addNewFlightFromExcel(Args filename){}
}
