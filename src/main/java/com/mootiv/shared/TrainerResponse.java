package com.mootiv.shared;

import com.mootiv.domain.persona.Trainer;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

import static java.util.Collections.emptyList;
import static java.util.Objects.nonNull;

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

    private List<StudentResponse> students;

    private Boolean active;

    private String alt_img;

    public static TrainerResponse mapFrom(Trainer trainer) {
        return TrainerResponse.builder()
                .id(trainer.getId())
                .dni(trainer.getDni())
                .name(trainer.getName())
                .lastName(trainer.getLastName())
                .email(trainer.getEmail())
                .telephone(trainer.getTelephone())
                .birthdate(trainer.getBirthdate())
                .students(nonNull(trainer.getStudents())
                        ? trainer.getStudents().stream()
                                    .map(StudentResponse::mapFrom)
                                    .toList()
                        : emptyList())
                .active(trainer.isActive())
                .alt_img(trainer.getAlt_img())
                .build();
    }

}
