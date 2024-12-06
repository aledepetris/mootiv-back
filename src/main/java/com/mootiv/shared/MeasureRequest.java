package com.mootiv.shared;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
public class MeasureRequest {

    private LocalDate date;
    private Float height;
    private Float weight;
    private Float shoulder;
    private Float chest;
    private Float arm;
    private Float waist;
    private Float hip;
    private Float leg;

}
