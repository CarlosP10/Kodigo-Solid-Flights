package com.kodigo.ui;

import com.kodigo.interfaces.FlightManager;
import com.kodigo.models.Flights;

import java.util.Scanner;

public class MenuManageFlight implements FlightManager {



    @Override
    public void manangerMenu() {
        MenuOptions menuOptions = new MenuOptions();
        Scanner scanner = new Scanner(System.in);
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
                updateFlight(new Flights());
                break;
            case 2:
                cancelFlight(new Flights());
                break;
            case 3:
                landedFlight(new Flights());
                break;
            case 4:
                menuOptions.flightMenu();
                break;
            default:
                System.out.println("You have entered an incorrect value.");
        }

    }

    @Override
    public void updateFlight(Flights flight) {
        MenuOptions menuOptions = new MenuOptions();
        System.out.println("--Current info--" + "\n");
        menuOptions.showFlight(flight);

        System.out.println("--Update info--" + "\n");
        menuOptions.addNewFlightFromShell();

    }

    @Override
    public void cancelFlight(Flights flight) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Reason why it was cancelled: ");
        String cancel = scanner.nextLine();
        flight.setValidate(cancel);
    }

    @Override
    public void landedFlight(Flights flight) {
        System.out.println("Flight has landed: ");
        flight.setValidate("Flight landed");
    }
}
