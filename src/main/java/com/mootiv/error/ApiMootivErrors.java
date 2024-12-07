package com.mootiv.error;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ApiMootivErrors {

    // GENERALES
    public static final ApiError TECHNICAL_ERROR = new ApiError("TechError", "Ups.");

    public static final ApiError MUSCLE_NOT_FOUND = new ApiError("MuscleNotFound", "Muscle not found");
    public static final ApiError MUSCLE_ALREADY_CREATED = new ApiError("MuscleAlreadyCreated", "Muscle already created");

    public static final ApiError EXERCISE_NOT_FOUND = new ApiError("ExerciseNotFound", "Exercise not found");
    public static final ApiError EXERCISE_ALREADY_CREATED = new ApiError("ExerciseAlreadyCreated", "Exercise already created");

    public static final ApiError EQUIPMENT_NOT_FOUND = new ApiError("EquipmentNotFound", "Equipment not found");
    public static final ApiError EQUIPMENT_ALREADY_CREATED = new ApiError("EquipmentAlreadyCreated", "Equipment already created");

    public static final ApiError EXERCISE_TYPE_NOT_FOUND = new ApiError("ExerciseTypeNotFound", "Exercise Type not found");
    public static final ApiError EXERCISE_TYPE_ALREADY_CREATED = new ApiError("ExerciseTypeAlreadyCreated", "Exercise Type already created");

    public static final ApiError TRAINING_TYPE_NOT_FOUND = new ApiError("TrainingTypeNotFound", "Training Type not found");
    public static final ApiError TRAINING_TYPE_ALREADY_CREATED = new ApiError("TrainingTypeAlreadyCreated", "Training Type already created");

    public static final ApiError AFFECTION_NOT_FOUND = new ApiError("AffectionNotFound", "Affection not found");
    public static final ApiError AFFECTION_ALREADY_CREATED = new ApiError("AffectionAlreadyCreated", "Affection already created");

    public static final ApiError GOAL_NOT_FOUND = new ApiError("GoalNotFound", "Goal not found");
    public static final ApiError GOAL_ALREADY_CREATED = new ApiError("GoalAlreadyCreated", "Goal already created");

    public static final ApiError TRAINER_NOT_FOUND = new ApiError("TrainerNotFound", "Trainer not found");
    public static final ApiError TRAINER_ALREADY_CREATED = new ApiError("TrainerAlreadyCreated", "Trainer already created");

    public static final ApiError STUDENT_NOT_FOUND = new ApiError("StudentNotFound", "Student not found");
    public static final ApiError STUDENT_ALREADY_CREATED = new ApiError("StudentAlreadyCreated", "Student already created");

    public static final ApiError MEASURE_NOT_FOUND = new ApiError("MeasureNotFound", "Measure not found");
    public static final ApiError MEASURE_ALREADY_CREATED = new ApiError("MeasureAlreadyCreated", "Measure already created");

    public static final ApiError TRAINING_PLACE_NOT_FOUND = new ApiError("TrainingPlaceNotFound", "Training Place not found");
    public static final ApiError TRAINING_PLACE_ALREADY_CREATED = new ApiError("TrainingPlaceAlreadyCreated", "Training Place already created");

    public static final ApiError CONDITION_NOT_FOUND = new ApiError("ConditionNotFound", "Condition not found");
    public static final ApiError CONDITION_ALREADY_CREATED = new ApiError("ConditionAlreadyCreated", "Condition already created");

    public static final ApiError GOAL_DAY_NOT_FOUND = new ApiError("GoalDayNotFound", "Combination of goal and day not exist");


    public static final String REQUIRED_FIELD = "El campo {0} es requerido y no fue informado";
    public static final String CAMPO_CON_VALOR_INVALIDO_CUSTOM = "Error en el campo {0}: {1}";
    public static final String CODE_ERROR_TECNICO = "ErrorTecnico";
}