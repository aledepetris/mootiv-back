package com.mootiv.shared;

import com.mootiv.domain.Condition;
import com.mootiv.domain.Measure;
import com.mootiv.domain.TrainingPlace;
import com.mootiv.domain.cycle.TrainingCycle;
import com.mootiv.domain.persona.Student;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class StudentResponse {

    private Integer id;
    private Long dni;
    private String name;
    private String lastName;
    private LocalDate startDate;
    private String trainer;
    private String email;
    private String telephone;
    private LocalDate birthdate;
    private Boolean active;
    private List<TrainingCycle> trainingCycles;
    private Set<Measure> measures;
    private Set<Condition> medicalHistory;
    private Set<TrainingPlace> trainingPlaces;

    public static StudentResponse mapFrom(Student student) {
        return StudentResponse.builder()
                .id(student.getId())
                .dni(student.getDni())
                .name(student.getName())
                .lastName(student.getLastName())
                .startDate(student.getStartDate())
                .trainer( isNull(student.getTrainer())
                        ? "Sin entrenador"
                        : student.getTrainer().getLastName() + ", " + student.getTrainer().getName())
                .email(student.getEmail())
                .telephone(student.getTelephone())
                .birthdate(student.getBirthdate())
                .active(student.isActive())
                .trainingCycles(
                            nonNull(student.getTrainingPlan().getTrainingCycles())
                                ? student.getTrainingPlan().getTrainingCycles()
                                : emptyList()
                )
                .measures(
                        nonNull(student.getMeasures())
                                ? student.getMeasures()
                                : emptySet()
                )
                .medicalHistory(
                        nonNull(student.getClinicalHistory().getConditions())
                                ? student.getClinicalHistory().getConditions()
                                : emptySet()
                )
                .trainingPlaces(
                        nonNull(student.getTrainingPlaces())
                                ? student.getTrainingPlaces()
                                : emptySet()
                )
                .build();

    }

}
