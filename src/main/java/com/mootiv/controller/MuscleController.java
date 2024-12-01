package com.mootiv.controller;

import com.mootiv.service.contract.MuscleCrudService;
import com.mootiv.shared.MuscleRequest;
import com.mootiv.shared.MuscleResponse;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bff/v1/muscle")
public class MuscleController {

    private final MuscleCrudService muscleCrudService;

    @Autowired
    public MuscleController(MuscleCrudService muscleCrudService) {
        this.muscleCrudService = muscleCrudService;
    }

    @GetMapping
    public ResponseEntity<List<MuscleResponse>> getMuscles() {
        return ResponseEntity
                .ok(muscleCrudService.getMuscles());
    }

    @PostMapping
    public ResponseEntity<MuscleResponse> addMuscle(@RequestBody @Valid MuscleRequest muscle) {
        return ResponseEntity
                .created(URI.create("/bff/v1/muscle"))
                .body(muscleCrudService.createMuscle(muscle));
    }


    @PutMapping("/{idMuscle}")
    public ResponseEntity<MuscleResponse> updateMuscle(@NotNull @PathVariable Integer idMuscle,
                                                       @RequestBody @Valid MuscleRequest muscle) {
        return ResponseEntity
                .ok(muscleCrudService.updateMuscle(idMuscle, muscle));
    }

    @GetMapping("/{idMuscle}")
    public ResponseEntity<MuscleResponse> getMuscle(@NotNull @PathVariable Integer idMuscle) {
        return ResponseEntity
                .ok(muscleCrudService.getMuscle(idMuscle));
    }

    @DeleteMapping("/{idMuscle}")
    public ResponseEntity<Void> deleteMuscle(@NotNull @PathVariable Integer idMuscle) {
        muscleCrudService.deleteMuscle(idMuscle);
        return ResponseEntity
                .noContent().build();
    }

}
