package com.mootiv.repository;

import com.mootiv.domain.plan.CycleStatus;
import com.mootiv.domain.plan.TrainingWeek;
import com.mootiv.domain.plan.TrainingWeekStatus;
import com.mootiv.error.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

import static com.mootiv.error.ApiMootivErrors.EQUIPMENT_NOT_FOUND;

@Repository
public interface TrainingWeekRepository extends JpaRepository<TrainingWeek, Integer> {

    Set<TrainingWeek> findByIdIn(List<Integer> ids);

    List<TrainingWeek> findByStatus(TrainingWeekStatus status);

    default Set<TrainingWeek> findListByIds(List<Integer> ids) {
        Set<TrainingWeek> week = findByIdIn(ids);
        if (week.size() != ids.size()) throw new NotFoundException(EQUIPMENT_NOT_FOUND);
        return week;
    }

}
