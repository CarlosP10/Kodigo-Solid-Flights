package com.kodigo.models;

import java.time.LocalDateTime;

public class FlightsInformation {
    private LocalDateTime time;

    public FlightsInformation(){

    }

    public FlightsInformation(LocalDateTime time){
        this.time = time;
    }

    public void addDelay(LocalDateTime delay){
        this.time = delay;
    }
}
