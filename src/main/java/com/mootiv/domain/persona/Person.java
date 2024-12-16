package com.mootiv.domain.persona;

import java.time.LocalDate;
import java.time.Period;

public abstract class Person {

    protected Long dni;

    protected String name;

    protected String lastName;

    protected String email;

    protected String alt_img;

    protected String telephone;

    protected LocalDate birthdate;

    private boolean active;

    public Integer getAge() {
        if (birthdate == null) {
            throw new IllegalStateException("Birthdate is not set");
        }
        return Period.between(birthdate, LocalDate.now()).getYears();

    }

}
