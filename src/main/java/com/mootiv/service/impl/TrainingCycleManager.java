package com.mootiv.service.impl;


import com.mootiv.error.exception.NotFoundException;
import com.mootiv.repository.GoalRepository;
import com.mootiv.repository.StudentRepository;
import com.mootiv.repository.TrainingTypeRepository;
import com.mootiv.service.TrainingCycleService;
import com.mootiv.shared.CycleRequest;
import org.springframework.stereotype.Service;

import static com.mootiv.error.ApiMootivErrors.*;

@Service
public class TrainingCycleManager implements TrainingCycleService {

    private final StudentRepository studentRepository;
    private final TrainingTypeRepository trainingTypeRepository;
    private final GoalRepository goalRepository;

    public TrainingCycleManager(StudentRepository studentRepository,
                                TrainingTypeRepository trainingTypeRepository,
                                GoalRepository goalRepository) {
        this.studentRepository = studentRepository;
        this.trainingTypeRepository = trainingTypeRepository;
        this.goalRepository = goalRepository;
    }

    @Override
    public void createTrainingCycle(Integer idStudent, CycleRequest cycleRequest) {

        var student = studentRepository.findById(idStudent)
                .orElseThrow(NotFoundException.of(STUDENT_NOT_FOUND));

        var trainingType = trainingTypeRepository.findById(cycleRequest.getIdTrainingType())
                .orElseThrow(NotFoundException.of(TRAINING_TYPE_NOT_FOUND));

        var goal = goalRepository.findById(cycleRequest.getIdGoal())
                .orElseThrow(NotFoundException.of(GOAL_NOT_FOUND));

        var trainingPlan = student.getTrainingPlan();

        trainingPlan.createNewCycle(cycleRequest.getStartDate(), cycleRequest.getNumberOfWeeks(), cycleRequest.getNumberOfDays(), goal, trainingType);

    }
}
