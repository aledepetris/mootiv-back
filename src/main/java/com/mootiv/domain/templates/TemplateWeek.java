package com.mootiv.domain.templates;

import com.mootiv.domain.plan.TrainingDay;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
public class TemplateWeek extends Template {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String name;
    private String description;
    private LocalDate creationDate;

    @ManyToMany
    List<TrainingDay> days;
}
