package com.kodigo.ui;

import com.kodigo.interfaces.FlightMenu;
import com.kodigo.models.Flights;
import org.apache.http.util.Args;

import java.util.Scanner;

public class MenuOptions implements FlightMenu {
    MenuManageFlight menuManageFlight = new MenuManageFlight();

    @Override
    public void flightMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------");
        System.out.println("Pick an option: ");
        System.out.println("1. Show flights ");
        System.out.println("2. Update flight ");
        System.out.println("3. New flight from shell");
        System.out.println("4. Import flights from Excel");
        System.out.println("--------------------------");
        int value = scanner.nextInt();

        switch (value) {
            case 1:
                showFlight(new Flights());
                break;
            case 2:
                menuManageFlight.manangerMenu();
                break;
            case 3:
                addNewFlightFromShell();
                break;
            case 4:
                addNewFlightFromExcel();
                break;
            default:
                System.out.println("You've entered an incorrect value, please try again.");
                break;
        }
    }

        @Override
        public void showFlight (Flights flights){
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
            System.out.println(flight);
        }

        @Override
        public void addNewFlightFromShell (){
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

            showFlight(flight);


        }

        @Override
        public void addNewFlightFromExcel (){

        }

}
