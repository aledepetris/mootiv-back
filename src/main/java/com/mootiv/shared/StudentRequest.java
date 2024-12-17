package com.mootiv.shared;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter @Setter
public class StudentRequest {

    private Integer idTrainer;

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

    private LocalDate startDate;
    private String alt_img;


}
