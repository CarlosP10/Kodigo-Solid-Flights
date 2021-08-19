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
