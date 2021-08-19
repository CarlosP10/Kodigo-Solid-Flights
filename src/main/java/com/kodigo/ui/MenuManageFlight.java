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
        System.out.println("Escoger una opcion: ");
        System.out.println("1. Actualizar Vuelo ");
        System.out.println("2. Cancelar Vuelo ");
        System.out.println("3. Vuelo Aterrizado ");
        System.out.println("4. Regresar ");
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
                System.out.println("Ha ingresado un valor incorrecto.");
        }

    }

    @Override
    public void updateFlight(Flights flight) {
        MenuOptions menuOptions = new MenuOptions();
        System.out.println("--INFORMACION ACTUAL--" + "\n");
        menuOptions.showFlight(flight);

        System.out.println("--ACTUALIZAR VUELO--" + "\n");
        menuOptions.addNewFlightFromShell();

    }

    @Override
    public void cancelFlight(Flights flight) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingresar razon por la cual es cancelado: ");
        String cancel = scanner.nextLine();
        flight.setValidate(cancel);
    }

    @Override
    public void landedFlight(Flights flight) {
        System.out.println("El avion ha aterrizado: ");
        flight.setValidate("Vuelvo ha aterrizado");
    }
}
