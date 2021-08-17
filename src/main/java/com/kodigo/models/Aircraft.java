package com.kodigo.models;

import lombok.*;

@Getter
@Setter
public class Aircraft {
    private String aircraft;
    private String airline;
    private int capacity;
    private String model;
    private int flyDistance;

    public Aircraft(){

    }

    public Aircraft(String airline, String model){
        this.airline = airline;
        this.model = model;
    }
}
