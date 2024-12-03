package com.mootiv.service;

import com.mootiv.shared.ExerciseTypeRequest;
import com.mootiv.shared.ExerciseTypeResponse;

import java.util.List;

public interface ExerciseTypeCrudService {

    List<ExerciseTypeResponse> getExerciseTypes();
    ExerciseTypeResponse createExerciseType(ExerciseTypeRequest request);
    ExerciseTypeResponse updateExerciseType(Integer id, ExerciseTypeRequest request);
    ExerciseTypeResponse getExerciseType(Integer id);
    void deleteExerciseType(Integer id);

}
