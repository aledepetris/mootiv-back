package com.mootiv.domain.goal;

import com.mootiv.domain.TrainingType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Getter @Setter
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "goal_id")
    private List<ScheduleGoal> scheduleGoals;

    public Set<TrainingType> getTrainingTypesByDaysOfTraining(Integer days) {
        return scheduleGoals.stream()
                .filter(scheduleGoal -> scheduleGoal.getDayOfTraining().equals(days))
                .flatMap(scheduleGoal -> scheduleGoal.getTrainingTypes().stream())
                .collect(Collectors.toSet());
    }

    public List<Integer> getDaysOfTrainng() {
        return scheduleGoals.stream()
                .map(ScheduleGoal::getDayOfTraining)
                .toList();
    }

}
