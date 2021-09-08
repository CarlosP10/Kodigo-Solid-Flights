package com.kodigo.ui;

import com.kodigo.interfaces.FlightManager;
import com.kodigo.models.Flights;
import com.kodigo.models.FlightsList;

import java.util.Scanner;

public class MenuManageFlight implements FlightManager {

    int currentFlightID = 0;

    @Override
    public void managerMenu(int flightId) {
        MenuOptions menuOptions = new MenuOptions();
        Scanner scanner = new Scanner(System.in);
        currentFlightID = flightId;
        Flights currentFlight = FlightsList.getFlightsList().FlightsList.get(flightId);
        System.out.println("--------------------------");
        System.out.println("Pick an option: ");
        System.out.println("1. Update flight");
        System.out.println("2. Cancel flight");
        System.out.println("3. Mark flight as landed");
        System.out.println("4. Back");
        System.out.println("--------------------------");
        int value = scanner.nextInt();

        switch (value){
            case 1:
                updateFlight(currentFlight);
                break;
            case 2:
                cancelFlight(currentFlight);
                break;
            case 3:
                landedFlight(currentFlight);
                break;
            case 4:
                menuOptions.flightMenu();
                break;
            default:
                System.out.println("You have entered an incorrect value.");
        }

    }

    //This method just update Flight and save it in the same position as the array
    @Override
    public void updateFlight(Flights flight) {
        MenuOptions menuOptions = new MenuOptions();

        System.out.println("--Current info--" + "\n");
        menuOptions.showFlight(flight);

        System.out.println("--Update info--" + "\n");
        menuOptions.addFlightInformation(flight);
        updateToList(flight);

    }

    //This method just update Validate value to Flight Cancel and give a reason
    @Override
    public void cancelFlight(Flights flight) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Reason why it was cancelled: ");
        String cancel = scanner.nextLine();
        flight.setValidate(cancel);
        updateToList(flight);
    }

    //This method just update Validate value to Flight Landed.
    @Override
    public void landedFlight(Flights flight) {

        System.out.println("Flight has landed: ");
        flight.setValidate("Flight landed");
        updateToList(flight);
    }

    //This method works to update de ArrayList that the user is creating.
    public void updateToList(Flights newFlight){
        FlightsList list = FlightsList.getFlightsList();
        list.FlightsList.set(currentFlightID, newFlight);
    }

}
