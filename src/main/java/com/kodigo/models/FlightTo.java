package com.kodigo.models;

import lombok.*;

@Getter @Setter
public class FlightTo {
        private String city;
        private String country;

        public FlightTo(){

        }

        public FlightTo(String city, String country){
            this.city = city;
            this.country = country;
    }
}
