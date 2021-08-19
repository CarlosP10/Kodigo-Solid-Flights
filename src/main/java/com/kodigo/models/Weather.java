package com.kodigo.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Weather {
    //Attributes for Weather
    private double temperature;
    private double precipitation;
    private double wind;
    private double humidity;
    private String weatherState;

    public String toPercentage(double value) {
        double percentage = (value * 100);
        return String.format("%.0f", percentage) + "%";
    }

}

