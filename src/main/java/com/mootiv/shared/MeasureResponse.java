package com.mootiv.shared;

import com.mootiv.domain.Measure;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class MeasureResponse {

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
    private Float bmi;
    private String bmiStatus;
    private Float waistToHipRatio;
    private Float waistToHeightRatio;

    public static MeasureResponse mapFrom(Measure measure) {
        return MeasureResponse.builder()
                .id(measure.getId())
                .startDate(measure.getDate())
                .height(measure.getHeight())
                .weight(measure.getWeight())
                .shoulder(measure.getShoulder())
                .chest(measure.getChest())
                .arm(measure.getArm())
                .waist(measure.getWaist())
                .hip(measure.getHip())
                .leg(measure.getLeg())
                .bmi(measure.calculateBMI())
                .bmiStatus(measure.getBMICategory().name())
                .waistToHipRatio(measure.calculateWaistToHipRatio())
                .waistToHeightRatio(measure.calculateWaistToHeightRatio())
                .build();
    }

}
