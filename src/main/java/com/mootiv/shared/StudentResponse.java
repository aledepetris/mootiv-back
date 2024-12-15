package com.mootiv.shared;

import com.mootiv.domain.Condition;
import com.mootiv.domain.Measure;
import com.mootiv.domain.TrainingPlace;
import com.mootiv.domain.persona.Student;
import com.mootiv.domain.plan.TrainingCycle;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import static java.util.Objects.isNull;

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
                .build();
    }

}
