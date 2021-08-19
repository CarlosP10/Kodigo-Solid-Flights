package com.kodigo.models;

import com.kodigo.provider.WeatherProvider;

public class Weather {
    public static void main(String[] args) {
        WeatherProvider.doHttpGet();
    }

}
