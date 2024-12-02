package com.mootiv.repository;

import com.mootiv.domain.Equipment;
import com.mootiv.domain.ExerciseType;
import com.mootiv.error.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.mootiv.error.ApiMootivErrors.MUSCLE_NOT_FOUND;

@Repository
public interface EquipmentRepository extends JpaRepository<Equipment, Integer> {

    Optional<Equipment> findByName(String name);
    Set<Equipment> findByIdIn(List<Integer> ids);
    default Set<Equipment> findListByIds(List<Integer> ids) {
        Set<Equipment> muscles = findByIdIn(ids);
        if (muscles.size() != ids.size()) throw new NotFoundException(MUSCLE_NOT_FOUND);
        return muscles;
    }

}
