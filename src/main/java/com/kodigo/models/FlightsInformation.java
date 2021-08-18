package com.kodigo.models;

import java.time.LocalDateTime;

public class FlightsInformation {
    private LocalDateTime time;
    //private LocalDateTime delay;

    public FlightsInformation(){

    }

    public FlightsInformation(LocalDateTime time){
        this.time = time;
    }
}
