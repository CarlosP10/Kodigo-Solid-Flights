package com.kodigo.ui;

import com.kodigo.interfaces.FlightMenu;
import com.kodigo.models.Flights;
import org.apache.http.util.Args;

import java.util.Scanner;

public class MenuOptions implements FlightMenu {

    @Override
    public void flightMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------");
        System.out.println("Escoger una opcion: ");
        System.out.println("1. Mostrar Vuelos ");
        System.out.println("2. Nuevo Vuelo desde consola");
        System.out.println("3. Nuevo Vuelo desde excel ");
        int value = scanner.nextInt();

        switch (value){
            case 1:
                showFlight(new Flights());
                break;
            case 2:
                addNewFlightFromShell(new Flights());
                break;
//            case 3:
//                addNewFlightFromExcel(Args dd);
//                break;
            default:
                System.out.println("Ha ingresado un valor incorrecto.");
                break;
    }

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
