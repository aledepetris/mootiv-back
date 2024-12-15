package com.mootiv.controller.student.cycle;

import com.mootiv.service.TrainingCycleService;
import com.mootiv.shared.CycleRequest;
import com.mootiv.shared.TrainingPlaceRequest;
import com.mootiv.shared.TrainingPlaceResponse;
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

    @PostMapping
    public ResponseEntity<Void> createCycle(@PathVariable Integer idStudent, CycleRequest cycleRequest) {
        trainingCycleService.createTrainingCycle(idStudent, cycleRequest);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<TrainingPlaceResponse>> getAllTrainingPlaces(@PathVariable Integer idStudent) {
        return ResponseEntity
                .ok(trainingCycleService.getTrainingPlaces(idStudent));
    }

    @PostMapping
    public ResponseEntity<TrainingPlaceResponse> addTrainingPlace(@PathVariable Integer idStudent, @RequestBody @Valid TrainingPlaceRequest requestBody) {
        trainingCycleService.createTrainingPlace(idStudent, requestBody);
        return ResponseEntity
                .created(URI.create("/bff/v1/student/"+ idStudent +"/training-place"))
                .build();
    }

    @PutMapping("/{idTrainingPlace}")
    public ResponseEntity<TrainingPlaceResponse> updateTrainingPlace(@PathVariable Integer idStudent, @PathVariable Integer idTrainingPlace,
                                                                     @RequestBody @Valid TrainingPlaceRequest requestBody) {
        trainingCycleService.updateTrainingPlace(idStudent, idTrainingPlace, requestBody);
        return ResponseEntity
                .noContent()
                .build();
    }

    @GetMapping("/{idTrainingPlace}")
    public ResponseEntity<TrainingPlaceResponse> getTrainingPlace(@PathVariable Integer idStudent, @PathVariable Integer idTrainingPlace) {
        return ResponseEntity.ok(studentTrainingPlaceService.getTrainingPlace(idStudent, idTrainingPlace));
    }

    @DeleteMapping("/{idTrainingPlace}")
    public ResponseEntity<Void> deleteEquipment(@PathVariable Integer idStudent, @PathVariable Integer idTrainingPlace) {
        trainingCycleService.deleteTrainingPlace(idStudent, idTrainingPlace);
        return ResponseEntity.noContent()
                .build();
    }

}
