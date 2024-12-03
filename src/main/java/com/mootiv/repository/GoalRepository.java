package com.mootiv.repository;

import com.mootiv.domain.goal.Goal;
import com.mootiv.domain.muscle.Muscle;
import com.mootiv.error.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.mootiv.error.ApiMootivErrors.EQUIPMENT_NOT_FOUND;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer> {

    Optional<Goal> findByName(String name);

    Set<Goal> findByIdIn(List<Integer> ids);

    default Set<Goal> findListByIds(List<Integer> ids) {
        Set<Goal> goal = findByIdIn(ids);
        if (goal.size() != ids.size()) throw new NotFoundException(EQUIPMENT_NOT_FOUND);
        return goal;
    }

}
