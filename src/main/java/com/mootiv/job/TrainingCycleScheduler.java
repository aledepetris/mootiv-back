package com.mootiv.job;

import lombok.extern.log4j.Log4j2;
import net.javacrumbs.shedlock.core.SchedulerLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class TrainingCycleScheduler {

    private final TrainigCycleAutomaticService service;

    @Autowired
    public TrainingCycleScheduler(TrainigCycleAutomaticService service) {
        this.service = service;
    }

    @Scheduled(fixedDelayString = "10000", initialDelayString = "10000")
    @SchedulerLock(name = "CycleChangeToInProgress", lockAtMostForString = "PT1H")
    public void jobChangeToInProgress() {
        service.changeCycleToInProgress();
    }

    @Scheduled(fixedDelayString = "10000", initialDelayString = "10000")
    @SchedulerLock(name = "CycleChangeToCompleted", lockAtMostForString = "PT1H")
    public void jobChangeToInCompleted() {
        service.changeCycleToCompleted();
    }

    @Scheduled(fixedDelayString = "10000", initialDelayString = "10000")
    @SchedulerLock(name = "WeekChangeToInProgress", lockAtMostForString = "PT1H")
    public void jobChangeWeekToInProgress() {
        service.changeWeekToInProgress();
    }

    @Scheduled(fixedDelayString = "10000", initialDelayString = "10000")
    @SchedulerLock(name = "WeekChangeToCompleted", lockAtMostForString = "PT1H")
    public void jobChangeWeekToCompleted() {
        service.changeWeekToCompleted();
    }

}
