package com.mootiv.repository;

import com.mootiv.domain.Exercise;
import com.mootiv.error.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import static com.mootiv.error.ApiMootivErrors.EXERCISE_NOT_FOUND;

public interface ExersiceRepository extends JpaRepository<Exercise, Integer> {

    List<Exercise> findByIdIn(List<Integer> ids);

    default List<Exercise> findListByIds(List<Integer> ids) {
        List<Exercise> exercises = findByIdIn(ids);
        if (exercises.size() != ids.size()) throw new NotFoundException(EXERCISE_NOT_FOUND);
        return exercises;
    }



}
