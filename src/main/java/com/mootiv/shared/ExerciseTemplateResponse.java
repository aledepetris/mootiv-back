package com.mootiv.shared;

import com.mootiv.domain.templates.TemplateExercises;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter @Setter
public class ExerciseTemplateResponse {

    Integer id;
    String name;
    LocalDate creationDate;
    List<ExerciseTemplateDto> exercises;

    public static ExerciseTemplateResponse mapFrom(TemplateExercises template) {

        return ExerciseTemplateResponse.builder()
                .id(template.getId())
                .name(template.getName())
                .creationDate(template.getCreationDate())
                .exercises(
                        template.getExercises().stream()
                                .map(ex -> ExerciseTemplateDto.builder()
                                        .exercise(ex.getExercise())
                                        .notes(ex.getNotes())
                                        .rest(ex.getRest())
                                        .sets(ex.getSets())
                                        .repetitions(ex.getRepetitions())
                                        .weight(ex.getWeight())
                                        .build())
                                .toList()
                ).build();

    }
}
