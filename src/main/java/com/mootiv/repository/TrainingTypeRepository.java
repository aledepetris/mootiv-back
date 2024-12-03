package com.mootiv.repository;

import com.mootiv.domain.TrainingType;
import com.mootiv.error.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.mootiv.error.ApiMootivErrors.TRAINING_TYPE_NOT_FOUND;

@Repository
public interface TrainingTypeRepository extends JpaRepository<TrainingType, Integer> {

    Optional<TrainingType> findByName(String name);

    Set<TrainingType> findByIdIn(List<Integer> ids);

    default Set<TrainingType> findListByIds(List<Integer> ids) {
        Set<TrainingType> trainingType = findByIdIn(ids);
        if (trainingType.size() != ids.size()) throw new NotFoundException(TRAINING_TYPE_NOT_FOUND);
        return trainingType;
    }

}
