package com.mootiv.service;

import com.mootiv.shared.MuscleRequest;
import com.mootiv.shared.MuscleResponse;

import java.util.Set;

public interface MuscleCrudService {

    Set<MuscleResponse> getMuscles();
    MuscleResponse createMuscle(MuscleRequest bodyRequest);
    MuscleResponse updateMuscle(Integer id, MuscleRequest bodyRequest);
    MuscleResponse getMuscle(Integer id);
    void deleteMuscle(Integer id);

}
