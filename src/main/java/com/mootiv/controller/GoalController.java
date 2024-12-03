package com.mootiv.controller;


import com.mootiv.service.GoalCrudService;
import com.mootiv.shared.GoalRequest;
import com.mootiv.shared.GoalResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/bff/v1/goal")
public class GoalController {

    private final GoalCrudService goalCrudService;

    public GoalController(GoalCrudService goalCrudService) {
        this.goalCrudService = goalCrudService;
    }

    @GetMapping
    public ResponseEntity<List<GoalResponse>> getAllGoals() {
        return ResponseEntity
                .ok(goalCrudService.getGoals());
    }

    @PostMapping
    public ResponseEntity<GoalResponse> addGoal(@RequestBody @Valid GoalRequest requestBody) {
        return ResponseEntity
                .created(URI.create("/bff/v1/goal"))
                .body(goalCrudService.createGoal(requestBody));
    }

    @PutMapping("/{idGoal}")
    public ResponseEntity<GoalResponse> updateGoal(@PathVariable Integer idGoal, @RequestBody @Valid GoalRequest requestBody) {
        return ResponseEntity.ok(goalCrudService.updateGoal(idGoal, requestBody));
    }

    @GetMapping("/{idGoal}")
    public ResponseEntity<GoalResponse> getGoal(@PathVariable Integer idGoal) {
        return ResponseEntity.ok(goalCrudService.getGoal(idGoal));
    }

    @DeleteMapping("/{idGoal}")
    public ResponseEntity<Void> deleteGoal(@PathVariable Integer idGoal) {
        goalCrudService.deleteGoal(idGoal);
        return ResponseEntity.noContent()
                .build();
    }

}
