package com.mootiv.service;

import com.mootiv.domain.Exercise;
import com.mootiv.domain.plan.CycleStatus;
import com.mootiv.domain.plan.ExerciseRoutine;
import com.mootiv.domain.plan.TrainingWeekStatus;
import com.mootiv.shared.*;

import java.util.List;

public interface TrainingCycleService {

    void createTrainingCycle(Integer idStudent, TrainingCycleRequest trainingCycleRequest);
    List<TrainingCycleResponse> getTrainingCycles(Integer idStudent);
    void updateTrainingCycle(Integer idStudent, Integer idTrainingCycle, TrainingCycleRequest bodyRequest);
    TrainingCycleResponse getTrainingCycle(Integer idStudent, Integer idTrainingCycle);
    void deleteTrainingCycle(Integer idStudent, Integer idTrainingCycle);

    void cambiarAEstado(Integer idStudent, Integer idTrainingCycle, CycleStatus status);

    TrainingCycleDetailResponse getTrainingCycleDetail(Integer idStudent, Integer idTrainingCycle);

    List<Exercise> getTrainingCycleAvailableExercise(Integer idStudent, Integer idTrainingCycle);

    void updateDay(Integer idStudent, Integer idDay, RequestDayOfTraining exerciseRoutines);

    void finishDay(Integer idStudent, Integer idDay);

    void cambiarSemanaEstado(Integer idStudent, Integer idWeek, TrainingWeekStatus cycleStatus);

    String generateWeekFile(Integer cycleId, Integer weekId, String fileType);
}
