package com.mootiv.controller;

import com.mootiv.service.ExerciseTypeCrudService;
import com.mootiv.shared.ExerciseTypeRequest;
import com.mootiv.shared.ExerciseTypeResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bff/v1/exercise-type")
public class ExerciseTypeController {

    private final ExerciseTypeCrudService exerciseTypeCrudService;

    @Autowired
    public ExerciseTypeController(ExerciseTypeCrudService exerciseTypeCrudService) {
        this.exerciseTypeCrudService = exerciseTypeCrudService;
    }

    @GetMapping
    public ResponseEntity<List<ExerciseTypeResponse>> getAllExerciseTypes() {
        return ResponseEntity
                .ok(exerciseTypeCrudService.getExerciseTypes());
    }

    @PostMapping
    public ResponseEntity<ExerciseTypeResponse> addExerciseType(@RequestBody @Valid ExerciseTypeRequest requestBody) {
        return ResponseEntity
                .created(URI.create("/bff/v1/exerciseType"))
                .body(exerciseTypeCrudService.createExerciseType(requestBody));
    }

    @PutMapping("/{idExerciseType}")
    public ResponseEntity<ExerciseTypeResponse> updateExerciseType(@PathVariable Integer idExerciseType, @RequestBody @Valid ExerciseTypeRequest requestBody) {
        return ResponseEntity.ok(exerciseTypeCrudService.updateExerciseType(idExerciseType, requestBody));
    }

    @GetMapping("/{idExerciseType}")
    public ResponseEntity<ExerciseTypeResponse> getExerciseType(@PathVariable Integer idExerciseType) {
        return ResponseEntity.ok(exerciseTypeCrudService.getExerciseType(idExerciseType));
    }

    @DeleteMapping("/{idExerciseType}")
    public ResponseEntity<Void> deleteExerciseType(@PathVariable Integer idExerciseType) {
        exerciseTypeCrudService.deleteExerciseType(idExerciseType);
        return ResponseEntity.noContent()
                .build();
    }

}
