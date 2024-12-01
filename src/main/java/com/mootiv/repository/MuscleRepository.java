package com.mootiv.repository;

import com.mootiv.domain.muscle.Muscle;
import com.mootiv.error.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import static com.mootiv.error.ApiMootivErrors.MUSCLE_NOT_FOUND;


public interface MuscleRepository extends JpaRepository<Muscle, Integer> {

    Optional<Muscle> findByName(String name);

    List<Muscle> findByIdIn(List<Integer> ids);

    default List<Muscle> findListByIds(List<Integer> ids) {
        List<Muscle> muscles = findByIdIn(ids);
        if (muscles.size() != ids.size()) throw new NotFoundException(MUSCLE_NOT_FOUND);
        return muscles;
    }

}
