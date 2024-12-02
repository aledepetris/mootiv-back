package com.mootiv.domain.persona;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
public class Trainer extends Student {

    private Set<Student> students;

    private boolean active;

}
