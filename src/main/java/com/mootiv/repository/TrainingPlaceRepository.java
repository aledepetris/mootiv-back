package com.mootiv.repository;

import com.mootiv.domain.Measure;
import com.mootiv.error.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

import static com.mootiv.error.ApiMootivErrors.EQUIPMENT_NOT_FOUND;

@Repository
public interface TrainingPlaceRepository extends JpaRepository<Measure, Integer> {

    Set<Measure> findByIdIn(List<Integer> ids);

    default Set<Measure> findListByIds(List<Integer> ids) {
        Set<Measure> affection = findByIdIn(ids);
        if (affection.size() != ids.size()) throw new NotFoundException(EQUIPMENT_NOT_FOUND);
        return affection;
    }

}
