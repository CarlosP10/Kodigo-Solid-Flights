package com.kodigo.ui;

import com.kodigo.interfaces.FlightMenu;
import com.kodigo.models.Flights;
import org.apache.http.util.Args;

public class MenuOptions implements FlightMenu {

    @Override
    public void showFlight(Flights flights) {
        StringBuilder flight = new StringBuilder();
        flight.append("-----------------------------").append("\n");
        flight.append("Departure: ").append(flights.getDeparture().getTime());

        flight.append("-----------------------------").append("\n");
    }

    @Override
    public void addNewFlightFromShell(Flights flight) {

    }

    @Override
    public void addNewFlightFromExcel(Args filename) {

    }
}
