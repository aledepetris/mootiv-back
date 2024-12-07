package com.mootiv.domain.cycle;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.IntStream;

@Entity
@Getter @Setter
@NoArgsConstructor
public class TrainingWeek {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate startDate;
    @OneToMany(cascade = CascadeType.ALL)
    private List<TrainingDay> days;
    private TrainingWeekStatus status;

    public boolean canBeEdited() {
        return this.status.equals(TrainingWeekStatus.COMPLETED)
                || this.status.equals(TrainingWeekStatus.POSTPONED)
                || this.status.equals(TrainingWeekStatus.CANCELED);
    }

    public void changeToPending() {
        if (this.status.equals(TrainingWeekStatus.DRAFT)) {
            this.status = TrainingWeekStatus.PENDING;
        } else {
            throw new RuntimeException("No es posible pasar a PENDING desde " + this.status.name());
        }
    }

    public void changeToInProgress() {
        if (this.status.equals(TrainingWeekStatus.DRAFT)) {
            this.status = TrainingWeekStatus.PENDING;
        } else {
            throw new RuntimeException("No es posible pasar a PENDING desde " + this.status.name());
        }
    }

    public void changeToCanceled() {
        if (!this.status.equals(TrainingWeekStatus.COMPLETED) && !this.status.equals(TrainingWeekStatus.POSTPONED)) {
            this.status = TrainingWeekStatus.CANCELED;
        }
    }

    public void changeToPostponed() {
        if (this.status.equals(TrainingWeekStatus.IN_PROGRESS) || this.status.equals(TrainingWeekStatus.PENDING)) {
            this.status = TrainingWeekStatus.POSTPONED;
        } else {
            throw new RuntimeException("No es posible pasar a POSTPONED desde " + this.status.name());
        }
    }

    public void changeToComplete() {
        if (isCompleted()) {
            this.status = TrainingWeekStatus.COMPLETED;
        }
    }

    public TrainingDay getLastDayTrained() {
        if (days == null || days.isEmpty()) {
            throw new RuntimeException("No training days available.");
        }

        return days.stream()
                .filter(TrainingDay::isCompleted)
                .max(Comparator.comparing(TrainingDay::getFinishDate))
                .orElseThrow(() -> new RuntimeException("No completed training days found."));
    }

    public LocalDate getDateOfFinish() {
        if (days == null || days.isEmpty()) {
            throw new RuntimeException("No training days available.");
        }
        return days.stream()
                .filter(TrainingDay::isCompleted)
                .max(Comparator.comparing(TrainingDay::getFinishDate))
                .map(TrainingDay::getFinishDate)
                .orElseThrow(() -> new RuntimeException("No completed training days found."));
    }

    public Float getProgress() {
        if (days == null || days.isEmpty()) {
            return 0F;
        }
        return Float.valueOf (days.stream()
                        .filter(TrainingDay::isCompleted)
                        .count() * days.size() * 100);

    }

    public boolean isCompleted() {
        return this.days.stream().allMatch(TrainingDay::isCompleted);
    }

    public boolean isInFinalState() {
        return this.status.equals(TrainingWeekStatus.COMPLETED) || this.status.equals(TrainingWeekStatus.POSTPONED);
    }

    public void createDaysOfTraining(Integer daysOfTraining) {
        this.days = IntStream.range(0, daysOfTraining)
                .mapToObj(day -> new TrainingDay())
                .toList();
    }

    public static TrainingWeek with(LocalDate weekStartDate, Integer daysOfTraining) {
        var trainingWeek = new TrainingWeek();
        trainingWeek.setStartDate(weekStartDate);
        trainingWeek.setStatus(TrainingWeekStatus.DRAFT);
        trainingWeek.createDaysOfTraining(daysOfTraining);
        return trainingWeek;
    }

}
