package com.kodigo.ui;

import com.kodigo.interfaces.FlightMenu;
import com.kodigo.models.Flights;
import org.apache.http.util.Args;

import java.util.Scanner;

public class MenuOptions implements FlightMenu {

    @Override
    public void showFlight(Flights flights) {
        StringBuilder flight = new StringBuilder();
        flight.append("-----------------------------").append("\n");
        flight.append("Departure: ").append(flights.getDeparture()).append("\n");
        flight.append("Arrivals: ").append(flights.getArrival()).append("\n");
        flight.append("Origin -> Country: ").append(flights.getOrigin()).append("\t")
                .append("--- City: ").append(flights.getOrigin()).append("\n");
        flight.append("Destination -> Country: ").append(flights.getDestination()).append("\t")
                .append("--- City: ").append(flights.getDestination()).append("\n");
        flight.append("Airline: ").append(flights.getAirline()).append("\n");
        flight.append("Aircraft: ").append(flights.getAircraft()).append("\n");
        flight.append("-----------------------------").append("\n");
    }

    @Override
    public void addNewFlightFromShell(Flights flight) {
        Scanner scanner = new Scanner(System.in);


    }

    @Override
    public void addNewFlightFromExcel(Args filename) {

    }
}
