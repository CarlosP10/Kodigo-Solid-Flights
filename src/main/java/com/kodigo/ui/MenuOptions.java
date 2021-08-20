package com.kodigo.ui;

import com.kodigo.SendMail;
import com.kodigo.interfaces.FlightMenu;
import com.kodigo.models.Flights;
import com.kodigo.models.FlightsList;

import java.util.Scanner;

public class MenuOptions implements FlightMenu {
    MenuManageFlight menuManageFlight = new MenuManageFlight();
    StringBuilder flightsString = new StringBuilder();
    FlightsList flightsList = FlightsList.getFlightsList();
    @Override
    public void flightMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------");
        System.out.println("Pick an option:");
        System.out.println("1. Show flights");
        System.out.println("2. Update flight");
        System.out.println("3. New flight from shell");
        System.out.println("4. Import flights from Excel");
        System.out.println("5. Generate report and send Email");
        System.out.println("--------------------------");
        int value = scanner.nextInt();

        switch (value) {
            case 1:
                if(flightsList.FlightsList.isEmpty()){
                    System.out.println("No information to show");

                    flightMenu();
                }
                else {
                    showAllFlights();
                }
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
            case 5:
                generateReports();
                break;
            default:
                System.out.println("You've entered an incorrect value, please try again.");
                flightMenu();
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
        flightsString.append(flight);
        System.out.println(flight);
//        return System.out.println(showInfo);;
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
        addFlightsToList(flight);
        flightMenu();

    }

    public void addFlightsToList (Flights flight) {
        flightsList.FlightsList.add(flight);
        System.out.println("Flight Added Successfully");
        flightMenu();
    }

    public void showAllFlights(){

        flightsList.FlightsList.forEach(flight -> {

            showFlight(flight);
        });
    }

    @Override
    public void addNewFlightFromExcel (){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write you excel name: ");
        String fileName = scanner.nextLine();
        System.out.println("Your fileName is " + fileName);
        flightMenu();
    }

    @Override
    public void generateReports() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write an email: ");
        String email = scanner.nextLine();
        SendMail.sendMailMethod(email, flightsString.toString());
        //method to send email
        System.out.println("Information has send to : " + email);
        flightMenu();
    }

}
