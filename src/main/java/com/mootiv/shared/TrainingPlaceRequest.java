package com.mootiv.shared;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class TrainingPlaceRequest {

    @NotBlank
    private String name;

    private Boolean all; // if wants to add all ?

    private List<Integer> idsEquipments;

}
