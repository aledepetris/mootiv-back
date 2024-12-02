package com.mootiv.domain.persona;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
public class Trainer extends Person {

    @OneToMany
    @JoinColumn(name = "trainer_id")
    private Set<Student> students;

    private boolean active;

}
