package com.kodigo.models;

import lombok.NonNull;

import java.util.ArrayList;

public class Flights {
    public static void main(String[] args) {
        Weather clima = new Weather(27,false);
        System.out.println(clima);
        clima.setTemperature(67.6);
        var hola = clima.toString();
        System.out.println(hola);

        var nombre = new ArrayList<String>();
        hola("h");
        clima.setPrecipitation(true);
        System.out.println("Esta lloviendo?");
        var lloviendo = clima.isPrecipitation();
        System.out.println(lloviendo);
    }
    public static void hola(@NonNull String obj){
        if (obj.contains("f")){
            throw new NullPointerException("come null");
        }
        System.out.println( obj);

    }
}
