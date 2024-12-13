package com.mootiv.shared;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class AffectionRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String description;
    private List<Integer> idsMusclesAffected;

}
