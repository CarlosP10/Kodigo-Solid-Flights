package com.kodigo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flights {
    private String id;
    Aircraft aircraft;
    FlightsInformation departure;
    FlightsInformation arrival;
    FlightTo origin;
    FlightTo destination;
    private String postalCode;
    Airline airline;
    private boolean validate;

}
