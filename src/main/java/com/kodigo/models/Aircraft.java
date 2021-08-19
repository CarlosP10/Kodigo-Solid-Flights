package com.kodigo.models;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
public class Aircraft {
    private int capacity;
    private String model;
    private double flyDistance;
//not needed thank to lombok
/*    public Aircraft(){

    }*/

//not needed thank to lombok
/*    public Aircraft(String model, int capacity, double flyDistance){
        this.model = model;
        this.capacity = capacity;
        this.flyDistance = flyDistance;
    }*/
}
