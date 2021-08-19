package com.kodigo.ui;

import com.kodigo.interfaces.FlightManager;
import com.kodigo.models.Flights;

import java.util.Scanner;

public class MenuManageFlight implements FlightManager {

    MenuOptions menuOptions;

    @Override
    public void manangerMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------------");
        System.out.println("Escoger una opcion: ");
        System.out.println("1. Actualizar Vuelo ");
        System.out.println("2. Cancelar Vuelo ");
        System.out.println("3. Vuelo Aterrizado ");
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
            default:
                System.out.println("Ha ingresado un valor incorrecto.");
        }

    }

    @Override
    public void updateFlight(Flights flight) {
        System.out.println("--INFORMACION ACTUAL--" + "\n");
        menuOptions.showFlight(flight);

        System.out.println("--ACTUALIZAR VUELO--" + "\n");
        menuOptions.addNewFlightFromShell(flight);

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
