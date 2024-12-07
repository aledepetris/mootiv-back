package com.mootiv.domain.goal;

import com.mootiv.domain.TrainingType;
import com.mootiv.error.exception.NotFoundException;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.mootiv.error.ApiMootivErrors.GOAL_DAY_NOT_FOUND;
import static com.mootiv.error.ApiMootivErrors.GOAL_NOT_FOUND;

@Entity
@Getter @Setter
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "goal_id")
    private Set<ScheduleGoal> scheduleGoals;

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

    public static Goal with(String name, String description, Set<ScheduleGoal> scheduleGoals) {
        var goal = new Goal();
        goal.setName(name);
        goal.setDescription(description);
        goal.setScheduleGoals(scheduleGoals);
        return goal;
    }

    public void update(String name, String description, Set<ScheduleGoal> scheduleGoals) {
        this.name = name;
        this.description = description;
        this.scheduleGoals = scheduleGoals;
    }

    public boolean validNumberOfDaysAndTraining(Integer numberOfDays, TrainingType trainingType) {
        return this.scheduleGoals.stream().filter(scheduleGoal -> scheduleGoal.getDayOfTraining().equals(numberOfDays))
                .findFirst()
                .orElseThrow(NotFoundException.of(GOAL_DAY_NOT_FOUND))
                        .getTrainingTypes().contains(trainingType);
    }
}
