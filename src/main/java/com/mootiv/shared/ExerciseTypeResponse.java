
package com.mootiv.shared;

import com.mootiv.domain.Equipment;
import com.mootiv.domain.ExerciseType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ExerciseTypeResponse {

    private Integer id;

    private String name;

    public static ExerciseTypeResponse mapFrom(ExerciseType exerciseType) {
        return new ExerciseTypeResponse(exerciseType.getId(), exerciseType.getName());
    }

}
