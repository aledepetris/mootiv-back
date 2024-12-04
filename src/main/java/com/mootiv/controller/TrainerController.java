package com.mootiv.controller;

import com.mootiv.service.TrainerCrudService;
import com.mootiv.shared.TrainerRequest;
import com.mootiv.shared.TrainerResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bff/v1/trainer")
public class TrainerController {

    private final TrainerCrudService trainerCrudService;

    public TrainerController(TrainerCrudService trainerCrudService) {
        this.trainerCrudService = trainerCrudService;
    }

    @GetMapping
    public ResponseEntity<List<TrainerResponse>> getAllTrainers() {
        return ResponseEntity
                .ok(trainerCrudService.getTrainers());
    }

    @PostMapping
    public ResponseEntity<TrainerResponse> addTrainer(@RequestBody @Valid TrainerRequest requestBody) {
        return ResponseEntity
                .created(URI.create("/bff/v1/trainer"))
                .body(trainerCrudService.createTrainer(requestBody));
    }

    @PutMapping("/{idTrainer}")
    public ResponseEntity<TrainerResponse> updateTrainer(@PathVariable Integer idTrainer, @RequestBody @Valid TrainerRequest requestBody) {
        return ResponseEntity.ok(trainerCrudService.updateTrainer(idTrainer, requestBody));
    }

    @GetMapping("/{idTrainer}")
    public ResponseEntity<TrainerResponse> getTrainer(@PathVariable Integer idTrainer) {
        return ResponseEntity.ok(trainerCrudService.getTrainer(idTrainer));
    }

}
