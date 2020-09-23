package com.mastercard.citychallenge.model;

import lombok.*;

@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Getter
@Setter
public class CityConnection {

    private String origin;
    private String destination;
}
