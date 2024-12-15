package com.mootiv.shared;


import com.mootiv.domain.Equipment;
import com.mootiv.domain.TrainingPlace;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter @Setter
public class TrainingPlaceResponse {

    private Integer id;

    private String name;

    List<String> equipments;

    List<Integer> idsEquipment;

    public static TrainingPlaceResponse mapFrom(TrainingPlace trainingPlace) {
        return TrainingPlaceResponse.builder()
                .id(trainingPlace.getId())
                .name(trainingPlace.getName())
                .equipments(trainingPlace.getEquipments().stream().map(Equipment::getName).toList())
                .idsEquipment(trainingPlace.getEquipments().stream().map(Equipment::getId).toList())
                .build();
    }

}
