package com.kodigo.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor

public class Report {
    private String id;
    Flights flights;
    Weather weather;
}
