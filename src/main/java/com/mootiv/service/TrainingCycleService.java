package com.mootiv.service;

import com.mootiv.shared.CycleRequest;

public interface TrainingCycleService {

    void createTrainingCycle(Integer idStudent, CycleRequest cycleRequest);
}
