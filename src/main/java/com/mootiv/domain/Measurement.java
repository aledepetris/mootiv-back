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
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate startDate;
    private Float height;
    private Float weight;
    private Float shoulder;
    private Float chest;
    private Float arm;
    private Float waist;
    private Float hip;
    private Float leg;

    public double calculateBMI() {
        return weight / (height * height);
    }

    public double calculateWaistToHipRatio() {
        if (hip == 0) {
            throw new IllegalArgumentException("Hip measurement cannot be zero.");
        }
        return waist / hip;
    }

    public double calculateWaistToHeightRatio() {
        if (height == 0) {
            throw new IllegalArgumentException("Height cannot be zero.");
        }
        return waist / (height * 100);
    }

    public BMIResult getBMICategory() {
        double bmi = calculateBMI();
        if (bmi < 18.5) return BMIResult.UNDERWEIGHT;
        if (bmi < 25) return BMIResult.NORMAL;
        if (bmi < 30) return BMIResult.OVERWEIGHT;
        return BMIResult.OBESITY;
    }

}
