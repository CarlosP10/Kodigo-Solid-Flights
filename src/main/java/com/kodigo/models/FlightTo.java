package com.kodigo.models;

import lombok.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FlightTo {
        private String city;
        private String country;
/*
        //se aplica lombok ya no es necdsario declararlo
        public FlightTo(){

        }*/

/*
        //ya no es necesario gracias a lombok
        public FlightTo(String city, String country){
            this.city = city;
            this.country = country;
    }*/
}
