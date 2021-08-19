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
    String aircraft;
    String departure;
    String arrival;
    String origin;
    String destination;
    private String postalCode;
    String airline;
    private String validate;

}
