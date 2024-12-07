package com.mootiv.controller.student.cycle;

import com.mootiv.service.TrainingCycleService;
import com.mootiv.shared.CycleRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
