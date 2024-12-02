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



    public static final String REQUIRED_FIELD = "El campo {0} es requerido y no fue informado";
    public static final String CAMPO_CON_VALOR_INVALIDO_CUSTOM = "Error en el campo {0}: {1}";
    public static final String CODE_ERROR_TECNICO = "ErrorTecnico";
}