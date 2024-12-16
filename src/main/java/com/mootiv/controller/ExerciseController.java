package com.mootiv.controller;

import com.mootiv.service.ExerciseCrudService;
import com.mootiv.shared.ExerciseRequest;
import com.mootiv.shared.ExerciseResponse;
import com.mootiv.shared.ExerciseTemplateWrap;
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
    public ResponseEntity< List<ExerciseTemplateWrap> > getAllWeekTemplate() {
        return ResponseEntity
                .ok(exerciseCrudService.getTemplateWeek());
    }

    @GetMapping("/templates")
    public ResponseEntity< List<ExerciseTemplateWrap> > getAllGrupoExerciseTemplate() {
        return ResponseEntity
                .ok(exerciseCrudService.getTemplateExercises());
    }

    @GetMapping("/templates-list")
    public ResponseEntity< List<ExerciseTemplateWrap> > getAllGrupoExerciseTemplateForEdit() {
        return ResponseEntity
                .ok(exerciseCrudService.getTemplateExercisesList());
    }

    @PostMapping("/templates")
    public ResponseEntity<ExerciseTemplateWrap> addTemplateExercise(@RequestBody @Valid ExerciseTemplateWrap requestBody) {
        return ResponseEntity
                .created(URI.create("/bff/v1/exercise"))
                .body(exerciseCrudService.createTemplate(requestBody));
    }

    @PutMapping("/templates/{idTemplate}")
    public ResponseEntity<ExerciseTemplateWrap> updateTemplateExercise(@PathVariable Integer idTemplate, @RequestBody @Valid ExerciseTemplateWrap requestBody) {
        return ResponseEntity.ok(exerciseCrudService.updateTemplate(idTemplate, requestBody));
    }

    @GetMapping("/templates/{idTemplate}")
    public ResponseEntity<ExerciseTemplateWrap> getTemplateExercise(@PathVariable Integer idTemplate) {
        return ResponseEntity.ok(exerciseCrudService.getExerciseTemplate(idTemplate));
    }

    @DeleteMapping("/templates/{idTemplate}")
    public ResponseEntity<Void> deleteTemplateExercise(@PathVariable Integer idTemplate) {
        exerciseCrudService.deleteExerciseTemplate(idTemplate);
        return ResponseEntity.noContent()
                .build();
    }

}
