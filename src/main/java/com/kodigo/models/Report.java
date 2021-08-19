package com.kodigo.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor

public class Report {
    //Flight report generate
    private String id;
    Flights flights;
    Weather weather;
}
