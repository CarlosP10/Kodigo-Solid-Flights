package com.kodigo.models;

import java.io.FileNotFoundException;

public class AddFlightsFromBatch {

    public void addBatch () {
        ExcelIn importExcel = new ExcelIn();
        Flights flight = new Flights();

        FlightsList flightsList = FlightsList.getFlightsList();

        String[][] excelFlights = importExcel.getExcelData();
        int length  = excelFlights.length;

        if (length == 0){
            return;
        }
        int width = excelFlights[0].length;

        for (int row = 1; row < length; row++) {
            for (int column = 0; column< width; column++ ){
                //0 -> Flight Number
                //1 -> Airline 5
                //2 -> Aircraft Type 6
                //3 -> Origin 3
                //4 -> Destination 4
                //5 -> Departure 1
                //6 -> Arrival 2
                switch (column) {
                    case 0 -> flight.setId(excelFlights[row][column]);
                    case 1 -> flight.setAirline(excelFlights[row][column]);
                    case 2 -> flight.setAircraft(excelFlights[row][column]);
                    case 3 -> flight.setOrigin(excelFlights[row][column]);
                    case 4 -> flight.setDestination(excelFlights[row][column]);
                    case 5 -> flight.setDeparture(excelFlights[row][column]);
                    case 6 -> flight.setArrival(excelFlights[row][column]);
                    default -> {
                        //
                    }
                }
            }
            flightsList.FlightsList.add(flight);
        }
    }
}
