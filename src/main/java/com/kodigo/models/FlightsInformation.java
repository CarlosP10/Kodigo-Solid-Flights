package com.kodigo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FlightsInformation {
    private LocalDateTime time;

    public void addDelay(LocalDateTime delay){
        this.time = delay;
    }
}
