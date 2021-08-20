package com.kodigo.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class FlightsList {

    private static FlightsList fFlightsList;

    private FlightsList() {    }

    public static synchronized FlightsList getFlightsList() {
        if (fFlightsList == null) {
            fFlightsList = new FlightsList();
        }
        return fFlightsList;
    }

    @Getter
    @Setter
    public ArrayList<String[][]> FlightsList = new ArrayList<>();

}
