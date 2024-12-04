package com.mootiv.controller;

import com.mootiv.service.TrainingTypeCrudService;
import com.mootiv.shared.TrainingTypeRequest;
import com.mootiv.shared.TrainingTypeResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bff/v1/training-type")
public class TrainingTypeController {

    private final TrainingTypeCrudService trainingTypeCrudService;

    public TrainingTypeController(TrainingTypeCrudService trainingTypeCrudService) {
        this.trainingTypeCrudService = trainingTypeCrudService;
    }

    @GetMapping
    public ResponseEntity<List<TrainingTypeResponse>> getAllTrainingTypes() {
        return ResponseEntity
                .ok(trainingTypeCrudService.getTrainingTypes());
    }

    @PostMapping
    public ResponseEntity<TrainingTypeResponse> addTrainingType(@RequestBody @Valid TrainingTypeRequest requestBody) {
        return ResponseEntity
                .created(URI.create("/bff/v1/training-type"))
                .body(trainingTypeCrudService.createTrainingType(requestBody));
    }

    @PutMapping("/{idTrainingType}")
    public ResponseEntity<TrainingTypeResponse> updateTrainingType(@PathVariable Integer idTrainingType, @RequestBody @Valid TrainingTypeRequest requestBody) {
        return ResponseEntity.ok(trainingTypeCrudService.updateTrainingType(idTrainingType, requestBody));
    }

    @GetMapping("/{idTrainingType}")
    public ResponseEntity<TrainingTypeResponse> getTrainingType(@PathVariable Integer idTrainingType) {
        return ResponseEntity.ok(trainingTypeCrudService.getTrainingType(idTrainingType));
    }

    @DeleteMapping("/{idTrainingType}")
    public ResponseEntity<Void> deleteTrainingType(@PathVariable Integer idTrainingType) {
        trainingTypeCrudService.deleteTrainingType(idTrainingType);
        return ResponseEntity.noContent()
                .build();
    }

}
