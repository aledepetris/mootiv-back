package com.mootiv.shared;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
public class MeasureRequest {

    private LocalDate startDate;
    private Float height;
    private Float weight;
    private Float shoulder;
    private Float chest;
    private Float arm;
    private Float waist;
    private Float hip;
    private Float leg;

}
