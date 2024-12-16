package com.mootiv.service;

import com.mootiv.shared.ExerciseRequest;
import com.mootiv.shared.ExerciseResponse;
import com.mootiv.shared.ExerciseTemplateResponse;

import java.util.List;

public interface ExerciseCrudService {

    List<ExerciseResponse> getExercise();
    ExerciseResponse createExercise(ExerciseRequest bodyRequest);
    ExerciseResponse updateExercise(Integer id, ExerciseRequest bodyRequest);
    ExerciseResponse getExercise(Integer id);
    void deleteExercise(Integer id);

    List<ExerciseTemplateResponse> getTemplateWeek();

    List<ExerciseTemplateResponse> getTemplateExercises();
}
