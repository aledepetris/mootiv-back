package com.mootiv.service.impl;

import com.mootiv.error.exception.NotFoundException;
import com.mootiv.repository.GoalRepository;
import com.mootiv.service.GoalCrudService;
import com.mootiv.shared.GoalRequest;
import com.mootiv.shared.GoalResponse;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.mootiv.error.ApiMootivErrors.GOAL_NOT_FOUND;

@Service
public class GoalCrud implements GoalCrudService {

    private final GoalRepository goalRepository;

    public GoalCrud(GoalRepository goalRepository) {
        this.goalRepository = goalRepository;
    }

    @Override
    public List<GoalResponse> getGoals() {
        return goalRepository.findAll().stream()
                .map(GoalResponse::mapFrom)
                .toList();
    }

    @Override
    public GoalResponse createGoal(GoalRequest request) {
        // TODO take when is finished TrainingType CRUD
        return null;
    }

    @Override
    public GoalResponse updateGoal(Integer id, GoalRequest request) {
        // TODO take when is finished TrainingType CRUD
        return null;
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
