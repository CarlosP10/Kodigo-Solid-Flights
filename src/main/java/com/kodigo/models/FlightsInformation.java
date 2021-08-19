package com.kodigo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightsInformation {
    private String time;

    public void addDelay(String delay){
        this.time = delay;
    }
}
