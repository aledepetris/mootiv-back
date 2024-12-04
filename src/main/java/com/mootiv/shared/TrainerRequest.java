package com.mootiv.shared;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter @Setter
public class TrainerRequest {

    @NotNull
    private Long dni;

    @NotBlank
    private String name;

    @NotBlank
    private String lastName;

    @NotBlank @Email
    private String email;

    @NotBlank
    private String telephone;

    @NotNull @DateTimeFormat
    private LocalDate birthdate;

    @NotEmpty
    private List<Integer> idsStudents;

    @NotNull
    private Boolean active;

}
