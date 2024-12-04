package com.mootiv.shared;

import com.mootiv.domain.persona.Trainer;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class TrainerResponse {

    private Integer id;

    private Long dni;

    private String name;

    private String lastName;

    private String email;

    private String telephone;

    private LocalDate birthdate;

    private List<String> students;

    private Boolean active;

    public static TrainerResponse mapFrom(Trainer trainer) {
        return TrainerResponse.builder()
                .id(trainer.getId())
                .dni(trainer.getDni())
                .name(trainer.getName())
                .lastName(trainer.getLastName())
                .email(trainer.getEmail())
                .telephone(trainer.getTelephone())
                .students(trainer.getStudents().stream()
                        .map(student -> student.getLastName() + ", " + student.getName())
                        .toList())
                .active(trainer.isActive())
                .build();
    }

}
