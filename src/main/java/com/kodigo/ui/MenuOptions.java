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
        Flights flight = new Flights();

        System.out.println("Insert aircraft type");
        String aircraft = scanner.nextLine();
        flight.setAircraft(aircraft);

        System.out.println("Insert departure:");
        String departure = scanner.nextLine();
        flight.setDeparture(departure);

        System.out.println("Insert arrival:");
        String arrival = scanner.nextLine();
        flight.setArrival(arrival);

        System.out.println("Insert origin:");
        String origin = scanner.nextLine();
        flight.setOrigin(origin);

        System.out.println("Insert destination:");
        String destination = scanner.nextLine();
        flight.setDestination(destination);

        System.out.println("Insert postal code");
        String postalCode = scanner.nextLine();
        flight.setPostalCode(postalCode);

        System.out.println("Insert airline:");
        String airline = scanner.nextLine();
        flight.setAirline(airline);


    }

    @Override
    public void addNewFlightFromExcel(Args filename) {

    }
}
