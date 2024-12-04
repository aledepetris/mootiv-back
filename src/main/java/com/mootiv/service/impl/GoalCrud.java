package com.mootiv.service.impl;

import com.mootiv.domain.goal.Goal;
import com.mootiv.domain.goal.ScheduleGoal;
import com.mootiv.error.exception.BusinessException;
import com.mootiv.error.exception.NotFoundException;
import com.mootiv.repository.GoalRepository;
import com.mootiv.repository.TrainingTypeRepository;
import com.mootiv.service.GoalCrudService;
import com.mootiv.shared.GoalRequest;
import com.mootiv.shared.GoalResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

import static com.mootiv.error.ApiMootivErrors.GOAL_ALREADY_CREATED;
import static com.mootiv.error.ApiMootivErrors.GOAL_NOT_FOUND;
import static java.util.Objects.isNull;
import static java.util.stream.Collectors.toSet;

@Service
public class GoalCrud implements GoalCrudService {

    private final GoalRepository goalRepository;
    private final TrainingTypeRepository trainingTypeRepository;

    public GoalCrud(GoalRepository goalRepository, TrainingTypeRepository trainingTypeRepository) {
        this.goalRepository = goalRepository;
        this.trainingTypeRepository = trainingTypeRepository;
    }

    @Override
    public List<GoalResponse> getGoals() {
        return goalRepository.findAll().stream()
                .map(GoalResponse::mapFrom)
                .toList();
    }

    @Override
    public GoalResponse createGoal(GoalRequest request) {

        if(isNull(request.getGoalTrainingTypes()) || request.getGoalTrainingTypes().isEmpty())
            throw new RuntimeException("Debe proporcionar al menos una scheduleGoal");

        var goal = goalRepository.findByName(request.getName());
        if (goal.isPresent()) {
            throw new BusinessException(GOAL_ALREADY_CREATED);
        }

        Set<ScheduleGoal> scheduleGoals = request.getGoalTrainingTypes()
                .stream()
                        .map(dto -> {
                            var listTraining = trainingTypeRepository.findListByIds(dto.getIdsTrainingTypes());
                            return new ScheduleGoal(dto.getDay(), listTraining);
                        })
                .collect(toSet());

        var goalSaved = goalRepository.save(Goal.with(request.getName(), request.getDescription(), scheduleGoals));
        return GoalResponse.mapFrom(goalSaved);

    }

    @Override
    public GoalResponse updateGoal(Integer id, GoalRequest request) {

        if(isNull(request.getGoalTrainingTypes()) || request.getGoalTrainingTypes().isEmpty())
            throw new RuntimeException("Debe proporcionar al menos una scheduleGoal");

        var goalToUpdate = goalRepository.findById(id)
                .orElseThrow(BusinessException.of(GOAL_NOT_FOUND));


        goalRepository.findByName(request.getName())
                .filter(existingGoal -> !existingGoal.getId().equals(id))
                .ifPresent(goal -> { throw new BusinessException(GOAL_ALREADY_CREATED);});

        Set<ScheduleGoal> scheduleGoals = request.getGoalTrainingTypes()
                .stream()
                .map(dto -> {
                    var listTraining = trainingTypeRepository.findListByIds(dto.getIdsTrainingTypes());
                    return new ScheduleGoal(dto.getDay(), listTraining);
                })
                .collect(toSet());

        goalToUpdate.update(request.getName(), request.getDescription(), scheduleGoals);

        var goalSaved = goalRepository.save(goalToUpdate);
        return GoalResponse.mapFrom(goalSaved);

    }

    @Override
    public GoalResponse getGoal(Integer id) {
        return goalRepository.findById(id)
                .map(GoalResponse::mapFrom)
                .orElseThrow(NotFoundException.of(GOAL_NOT_FOUND));
    }

    @Override
    public void deleteGoal(Integer id) {
        try {
            goalRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new RuntimeException("No es posible eliminar este recurso ya que se encuentra asociado a otra entidad.");
        }
    }

}
