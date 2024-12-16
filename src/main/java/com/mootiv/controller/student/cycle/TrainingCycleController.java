package com.mootiv.controller.student.cycle;

import com.mootiv.domain.Exercise;
import com.mootiv.domain.plan.CycleStatus;
import com.mootiv.domain.plan.ExerciseRoutine;
import com.mootiv.service.TrainingCycleService;
import com.mootiv.shared.TrainingCycleDetailResponse;
import com.mootiv.shared.TrainingCycleRequest;
import com.mootiv.shared.TrainingCycleResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bff/v1/student/{idStudent}/cycle")
public class TrainingCycleController {

    private final TrainingCycleService trainingCycleService;

    public TrainingCycleController(TrainingCycleService trainingCycleService) {
        this.trainingCycleService = trainingCycleService;
    }

    @GetMapping
    public ResponseEntity<List<TrainingCycleResponse>> getAllTrainingCycles(@PathVariable Integer idStudent) {
        return ResponseEntity
                .ok(trainingCycleService.getTrainingCycles(idStudent));
    }

    @PostMapping
    public ResponseEntity<TrainingCycleResponse> addTrainingCycle(@PathVariable Integer idStudent, @RequestBody @Valid TrainingCycleRequest requestBody) {
        trainingCycleService.createTrainingCycle(idStudent, requestBody);
        return ResponseEntity
                .created(URI.create("/bff/v1/student/"+ idStudent +"/cycle"))
                .build();
    }

    @PutMapping("/{idTrainingCycle}")
    public ResponseEntity<TrainingCycleResponse> updateTrainingCycle(@PathVariable Integer idStudent, @PathVariable Integer idTrainingCycle,
                                                                     @RequestBody @Valid TrainingCycleRequest requestBody) {
        trainingCycleService.updateTrainingCycle(idStudent, idTrainingCycle, requestBody);
        return ResponseEntity
                .noContent()
                .build();
    }

    @PutMapping("/{idTrainingCycle}/{status}")
    public ResponseEntity<TrainingCycleResponse> updateTrainingCycle(@PathVariable Integer idStudent, @PathVariable Integer idTrainingCycle,
                                                                     @PathVariable String status) {

        if (!CycleStatus.isValidValue(status)) {
            throw new RuntimeException("El estado ingresado no se encuentra dentro de los valores permitidos");
        }

        trainingCycleService.cambiarAEstado(idStudent, idTrainingCycle, CycleStatus.valueOf(status));

        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/{idTrainingCycle}")
    public ResponseEntity<TrainingCycleResponse> getTrainingCycle(@PathVariable Integer idStudent, @PathVariable Integer idTrainingCycle) {
        return ResponseEntity.ok(trainingCycleService.getTrainingCycle(idStudent, idTrainingCycle));
    }

    @DeleteMapping("/{idTrainingCycle}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable Integer idStudent, @PathVariable Integer idTrainingCycle) {
        trainingCycleService.deleteTrainingCycle(idStudent, idTrainingCycle);
        return ResponseEntity.noContent()
                .build();
    }

    @GetMapping("/{idTrainingCycle}/detail")
    public ResponseEntity<TrainingCycleDetailResponse> getTrainingCycleDetail(@PathVariable Integer idStudent, @PathVariable Integer idTrainingCycle) {
        return ResponseEntity.ok(trainingCycleService.getTrainingCycleDetail(idStudent, idTrainingCycle));
    }

    @GetMapping("/{idTrainingCycle}/exercise")
    public ResponseEntity<List<Exercise>> getTrainingCycleAvailableExercise(@PathVariable Integer idStudent, @PathVariable Integer idTrainingCycle) {
        return ResponseEntity.ok(trainingCycleService.getTrainingCycleAvailableExercise(idStudent, idTrainingCycle));
    }

}
