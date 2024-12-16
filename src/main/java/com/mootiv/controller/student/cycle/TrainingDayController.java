package com.mootiv.controller.student.cycle;

import com.mootiv.domain.Exercise;
import com.mootiv.domain.plan.ExerciseRoutine;
import com.mootiv.service.TrainingCycleService;
import com.mootiv.shared.ExerciseRoutineRequest;
import com.mootiv.shared.RequestDayOfTraining;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bff/v1/student/{idStudent}/day/")
public class TrainingDayController {

    private final TrainingCycleService trainingCycleService;

    public TrainingDayController(TrainingCycleService trainingCycleService) {
        this.trainingCycleService = trainingCycleService;
    }

    @PutMapping("/{idDay}")
    public ResponseEntity<List<Exercise>> getTrainingCycleAvailableExercise(@PathVariable Integer idStudent,
                                                                            @PathVariable Integer idDay,
                                                                            @RequestBody RequestDayOfTraining data) {
        trainingCycleService.updateDay(idStudent, idDay, data);
        return ResponseEntity.noContent()
                .build();
    }

    @PutMapping("/{idDay}/finish")
    public ResponseEntity<List<Exercise>> finishDay(@PathVariable Integer idStudent,
                                                    @PathVariable Integer idDay) {
        trainingCycleService.finishDay(idStudent, idDay);
        return ResponseEntity.noContent()
                .build();
    }

}
