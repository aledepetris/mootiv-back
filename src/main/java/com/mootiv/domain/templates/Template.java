package com.mootiv.domain.templates;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Getter @Setter
abstract class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    Integer id;
    String name;
    LocalDate creationDate;

}
