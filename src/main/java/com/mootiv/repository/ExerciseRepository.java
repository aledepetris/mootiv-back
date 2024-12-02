package com.mootiv.repository;

import com.mootiv.domain.Exercise;
import com.mootiv.error.exception.NotFoundException;
import com.mootiv.shared.ExerciseRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.mootiv.error.ApiMootivErrors.EXERCISE_NOT_FOUND;

@Repository
public interface ExerciseRepository extends JpaRepository<Exercise, Integer> {

    Set<Exercise> findByIdIn(List<Integer> ids);

    default Set<Exercise> findListByIds(List<Integer> ids) {
        Set<Exercise> exercises = findByIdIn(ids);
        if (exercises.size() != ids.size()) throw new NotFoundException(EXERCISE_NOT_FOUND);
        return exercises;
    }

    Optional<Exercise> findByName(String name);
}
