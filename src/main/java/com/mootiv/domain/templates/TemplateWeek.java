package com.mootiv.domain.templates;

import com.mootiv.domain.plan.TrainingDay;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter @Setter
public class TemplateWeek extends Template {

    @ManyToMany
    List<TrainingDay> days;
}
