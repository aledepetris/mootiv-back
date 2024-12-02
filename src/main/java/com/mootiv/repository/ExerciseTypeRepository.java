package com.mootiv.repository;

import com.mootiv.domain.ExerciseType;
import com.mootiv.domain.muscle.Muscle;
import com.mootiv.error.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.mootiv.error.ApiMootivErrors.MUSCLE_NOT_FOUND;

@Repository
public interface ExerciseTypeRepository extends JpaRepository<ExerciseType, Integer> {

    Optional<ExerciseType> findByName(String name);

    Set<ExerciseType> findByIdIn(List<Integer> ids);

    default Set<ExerciseType> findListByIds(List<Integer> ids) {
        Set<ExerciseType> muscles = findByIdIn(ids);
        if (muscles.size() != ids.size()) throw new NotFoundException(MUSCLE_NOT_FOUND);
        return muscles;
    }


}
