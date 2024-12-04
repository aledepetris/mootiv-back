package com.mootiv.domain.goal;

import com.mootiv.domain.TrainingType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter
@NoArgsConstructor
public class ScheduleGoal {

    public ScheduleGoal(Integer id, Integer dayOfTraining) {
        this.id = id;
        this.dayOfTraining = dayOfTraining;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer dayOfTraining;

    @ManyToMany
    private Set<TrainingType> trainingTypes;

    public ScheduleGoal(Integer day, Set<TrainingType> trainingTypes) {
        this.dayOfTraining = day;
        this.trainingTypes = trainingTypes;
    }
}
