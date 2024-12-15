package com.mootiv.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter @Setter
public class Measure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate date;
    private Float height;
    private Float weight;
    private Float shoulder;
    private Float chest;
    private Float arm;
    private Float waist;
    private Float hip;
    private Float leg;

    public Float calculateBMI() {
        Float heightInMeters = height / 100;
        return weight / (heightInMeters * heightInMeters);
    }


    public Float calculateWaistToHipRatio() {
        if (hip == 0) {
            throw new IllegalArgumentException("Hip measurement cannot be zero.");
        }
        return waist / hip;
    }

    public Float calculateWaistToHeightRatio() {
        if (height == 0) {
            throw new IllegalArgumentException("Height cannot be zero.");
        }
        return waist / (height * 100);
    }

    public BMIResult getBMICategory() {
        Float bmi = calculateBMI();
        if (bmi < 18.5) return BMIResult.BAJO_PESO;
        if (bmi < 25) return BMIResult.NORMAL;
        if (bmi < 30) return BMIResult.SOBREPESO;
        return BMIResult.OBESIDAD;
    }

}
