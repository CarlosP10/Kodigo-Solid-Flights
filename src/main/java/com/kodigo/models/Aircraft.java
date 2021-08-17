package com.kodigo.models;

import lombok.*;

@Getter
@Setter
public class Aircraft {
    private int capacity;
    private String model;
    private double flyDistance;

    public Aircraft(){

    }

    public Aircraft(String model, int capacity, double flyDistance){
        this.model = model;
        this.capacity = capacity;
        this.flyDistance = flyDistance;
    }
}
