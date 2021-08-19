package com.kodigo.models;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
public class Aircraft {
    //Aircraft capacity
    private int capacity;
    //Aircraft model number or name
    private String model;
    //Aircraft flyDistance
    private double flyDistance;

}
