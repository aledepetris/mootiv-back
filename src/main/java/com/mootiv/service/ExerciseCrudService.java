package com.mootiv.service;

import com.mootiv.shared.ExerciseRequest;
import com.mootiv.shared.ExerciseResponse;
import com.mootiv.shared.ExerciseTemplateDto;
import com.mootiv.shared.ExerciseTemplateWrap;

import java.util.List;

public interface ExerciseCrudService {

    List<ExerciseResponse> getExercise();
    ExerciseResponse createExercise(ExerciseRequest bodyRequest);
    ExerciseResponse updateExercise(Integer id, ExerciseRequest bodyRequest);
    ExerciseResponse getExercise(Integer id);
    void deleteExercise(Integer id);

    List<ExerciseTemplateWrap> getTemplateWeek();

    List<ExerciseTemplateWrap> getTemplateExercises();

    ExerciseTemplateWrap createTemplate(ExerciseTemplateWrap requestBody);

    ExerciseTemplateWrap updateTemplate(Integer idTemplate, ExerciseTemplateWrap requestBody);


    ExerciseTemplateWrap getExerciseTemplate(Integer idTemplate);

    void deleteExerciseTemplate(Integer idTemplate);

    List<ExerciseTemplateWrap> getTemplateExercisesList();
}
