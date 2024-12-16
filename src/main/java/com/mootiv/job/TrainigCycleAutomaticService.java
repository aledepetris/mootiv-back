package com.mootiv.job;

import com.mootiv.domain.plan.CycleStatus;
import com.mootiv.domain.plan.TrainingWeekStatus;
import com.mootiv.repository.TrainingCycleRepository;
import com.mootiv.repository.TrainingWeekRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainigCycleAutomaticService {

    private final TrainingCycleRepository repositoryCycle;
    private final TrainingWeekRepository repositotyWeek;

    @Autowired
    public TrainigCycleAutomaticService(TrainingCycleRepository repositoryCycle, TrainingWeekRepository repositotyWeek) {
        this.repositoryCycle = repositoryCycle;
        this.repositotyWeek = repositotyWeek;
    }

    @Transactional
    public void changeCycleToInProgress() {
        repositoryCycle.findByStatus(CycleStatus.PENDIENTE)
                        .forEach(trainingCycle -> {
                            trainingCycle.changeToInProgress();
                            repositoryCycle.save(trainingCycle);
                        });

    }

    @Transactional
    public void changeCycleToCompleted() {
        repositoryCycle.findByStatus(CycleStatus.EN_PROGRESO)
                .forEach(trainingCycle -> {
                    trainingCycle.changeToCompleted();
                    repositoryCycle.save(trainingCycle);
                });
    }

    @Transactional
    public void changeWeekToInProgress() {
        repositotyWeek.findByStatus(TrainingWeekStatus.PENDIENTE)
                .forEach(trainingWeek -> {
                    trainingWeek.changeToInProgress();
                    repositotyWeek.save(trainingWeek);
                });
    }

    @Transactional
    public void changeWeekToCompleted() {
        repositotyWeek.findByStatus(TrainingWeekStatus.EN_PROGRESO)
                .forEach(trainingWeek -> {
                    trainingWeek.changeToComplete();
                    repositotyWeek.save(trainingWeek);
                });
    }
}
