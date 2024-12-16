package com.mootiv.repository;

import com.mootiv.domain.plan.CycleStatus;
import com.mootiv.domain.plan.TrainingCycle;
import com.mootiv.error.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

import static com.mootiv.error.ApiMootivErrors.EQUIPMENT_NOT_FOUND;

@Repository
public interface TrainingCycleRepository extends JpaRepository<TrainingCycle, Integer> {

    Set<TrainingCycle> findByIdIn(List<Integer> ids);

    List<TrainingCycle> findByStatus(CycleStatus status);

    default Set<TrainingCycle> findListByIds(List<Integer> ids) {
        Set<TrainingCycle> trainingCycle = findByIdIn(ids);
        if (trainingCycle.size() != ids.size()) throw new NotFoundException(EQUIPMENT_NOT_FOUND);
        return trainingCycle;
    }

}
