package com.mootiv.repository;

import com.mootiv.domain.Affection;
import com.mootiv.error.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.mootiv.error.ApiMootivErrors.EQUIPMENT_NOT_FOUND;

@Repository
public interface AffectionRepository extends JpaRepository<Affection, Integer> {

    Optional<Affection> findByName(String name);

    Set<Affection> findByIdIn(List<Integer> ids);

    default Set<Affection> findListByIds(List<Integer> ids) {
        Set<Affection> affection = findByIdIn(ids);
        if (affection.size() != ids.size()) throw new NotFoundException(EQUIPMENT_NOT_FOUND);
        return affection;
    }

}
