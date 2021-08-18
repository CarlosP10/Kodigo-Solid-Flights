package com.kodigo.models;


import lombok.*;

@Getter
@Setter
public class Airline {
    private String airlineName;

    public Airline(){

    }
    public Airline(String airlineName){
        this.airlineName = airlineName;
    }
}
