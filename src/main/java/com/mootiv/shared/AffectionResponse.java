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
    private List<String> musclesAffected;

    public static AffectionResponse mapFrom(Affection affection) {
        return AffectionResponse.builder()
                .id(affection.getId())
                .name(affection.getName())
                .description(affection.getDescription())
                .musclesAffected(affection.getMusclesAffected().stream()
                        .map(Muscle::getName)
                        .toList()
                )
                .build();
    }

}
