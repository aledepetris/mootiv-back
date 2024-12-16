package com.mootiv.controller;

import com.mootiv.service.ExerciseCrudService;
import com.mootiv.shared.ExerciseRequest;
import com.mootiv.shared.ExerciseResponse;
import com.mootiv.shared.ExerciseTemplateDto;
import com.mootiv.shared.ExerciseTemplateResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bff/v1/exercise")
public class ExerciseController {

    private final ExerciseCrudService exerciseCrudService;

    @Autowired
    public ExerciseController(ExerciseCrudService exerciseCrudService) {
        this.exerciseCrudService = exerciseCrudService;
    }

    @GetMapping
    public ResponseEntity<List<ExerciseResponse>> getAllExercises() {
        return ResponseEntity
                .ok(exerciseCrudService.getExercise());
    }

    @PostMapping
    public ResponseEntity<ExerciseResponse> addExercise(@RequestBody @Valid ExerciseRequest requestBody) {
        return ResponseEntity
                .created(URI.create("/bff/v1/exercise"))
                .body(exerciseCrudService.createExercise(requestBody));
    }

    @PutMapping("/{idExercise}")
    public ResponseEntity<ExerciseResponse> updateExercise(@PathVariable Integer idExercise, @RequestBody @Valid ExerciseRequest requestBody) {
        return ResponseEntity.ok(exerciseCrudService.updateExercise(idExercise, requestBody));
    }

    @GetMapping("/{idExercise}")
    public ResponseEntity<ExerciseResponse> getExercise(@PathVariable Integer idExercise) {
        return ResponseEntity.ok(exerciseCrudService.getExercise(idExercise));
    }

    @DeleteMapping("/{idExercise}")
    public ResponseEntity<Void> deleteExercise(@PathVariable Integer idExercise) {
        exerciseCrudService.deleteExercise(idExercise);
        return ResponseEntity.noContent()
                .build();
    }

    @GetMapping("/templates/week")
    public ResponseEntity< List<ExerciseTemplateResponse> > getAllWeekTemplate() {
        return ResponseEntity
                .ok(exerciseCrudService.getTemplateWeek());
    }

    @GetMapping("/templates")
    public ResponseEntity< List<ExerciseTemplateResponse> > getAllGrupoExerciseTemplate() {
        return ResponseEntity
                .ok(exerciseCrudService.getTemplateExercises());
    }

}
