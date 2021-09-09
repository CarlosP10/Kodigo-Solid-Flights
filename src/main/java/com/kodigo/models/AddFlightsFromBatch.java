package com.kodigo.models;

public class AddFlightsFromBatch {



    public void addBatch () {
        ExcelIn importExcel = new ExcelIn();
        FlightsList flightsList = FlightsList.getFlightsList();
        Flights flight = new Flights();

        String[][] excelFlights = importExcel.getExcelData();

        if (excelFlights.length == 0){
            return;
        }

        int l = excelFlights.length;
        int w = excelFlights[0].length;

        for (int i = 1; i < l; i++) {
            for (int j = 0; j< w; j++ ){
                //0 -> Flight Number
                //1 -> Airline 5
                //2 -> Aircraft Type 6
                //3 -> Origin 3
                //4 -> Destination 4
                //5 -> Departure 1
                //6 -> Arrival 2
                switch (j) {
                    case 0 -> flight.setId(excelFlights[i][j]);
                    case 1 -> flight.setAirline(excelFlights[i][j]);
                    case 2 -> flight.setAircraft(excelFlights[i][j]);
                    case 3 -> flight.setOrigin(excelFlights[i][j]);
                    case 4 -> flight.setDestination(excelFlights[i][j]);
                    case 5 -> flight.setDeparture(excelFlights[i][j]);
                    case 6 -> flight.setArrival(excelFlights[i][j]);
                    default -> {
                        //
                    }
                }
            }
            flightsList.FlightsList.add(flight);
        }
    }
}
