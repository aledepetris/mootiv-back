package com.mootiv.shared;

import com.mootiv.domain.templates.TemplateExercises;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Builder
@Getter @Setter
public class ExerciseTemplateWrap {

    Integer id;
    String name;
    String description;
    LocalDate creationDate;
    List<ExerciseTemplateDto> exercises;

    public static ExerciseTemplateWrap mapFrom(TemplateExercises template, boolean idRequired) {

        return ExerciseTemplateWrap.builder()
                .id(template.getId())
                .name(template.getName())
                .description(template.getDescription())
                .creationDate(template.getCreationDate())
                .exercises(
                        template.getExercises().stream()
                                .map(ex -> ExerciseTemplateDto.builder()
                                        .id(idRequired ? ex.getId(): null)
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
