package com.mootiv.service.contract;

import com.mootiv.shared.ExerciseRequest;
import com.mootiv.shared.ExerciseResponse;

import java.util.List;

public interface ExerciseCrudService {

    List<ExerciseResponse> getExercise();
    ExerciseResponse createExercise(ExerciseRequest bodyRequest);
    ExerciseResponse updateExercise(Integer id, ExerciseRequest bodyRequest);
    ExerciseResponse getExercise(Integer id);
    void deleteExercise(Integer id);

}
