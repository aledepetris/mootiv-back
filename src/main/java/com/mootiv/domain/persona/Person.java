package com.mootiv.domain.persona;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Getter @Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private Long dni;

    private String name;

    private String lastName;

    private String email;

    private String telephone;

    private LocalDate birthdate;

    public Integer getAge() {
        if (birthdate == null) {
            throw new IllegalStateException("Birthdate is not set");
        }
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

}
