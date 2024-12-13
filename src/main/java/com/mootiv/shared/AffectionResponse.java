package com.mootiv.shared;

import com.mootiv.domain.Affection;
import com.mootiv.domain.Exercise;
import com.mootiv.domain.muscle.Muscle;
import lombok.*;

import java.util.List;

@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class AffectionResponse {

    private Integer id;
    private String name;
    private String description;
    private List<Integer> idsMusclesAffected;

    public static AffectionResponse mapFrom(Affection affection) {
        return AffectionResponse.builder()
                .id(affection.getId())
                .name(affection.getName())
                .description(affection.getDescription())
                .idsMusclesAffected(affection.getMusclesAffected().stream()
                        .map(Muscle::getId)
                        .toList()
                )
                .build();
    }

}
