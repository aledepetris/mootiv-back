package com.mootiv.service;

import com.mootiv.shared.GoalRequest;
import com.mootiv.shared.GoalResponse;

import java.util.List;

public interface GoalCrudService {

    List<GoalResponse> getGoals();
    GoalResponse createGoal(GoalRequest bodyRequest);
    GoalResponse updateGoal(Integer id, GoalRequest bodyRequest);
    GoalResponse getGoal(Integer id);
    void deleteGoal(Integer id);

}
