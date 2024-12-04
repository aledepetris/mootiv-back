package com.mootiv.repository;

import com.mootiv.domain.persona.Trainer;
import com.mootiv.error.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.mootiv.error.ApiMootivErrors.TRAINER_NOT_FOUND;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Integer> {

    Optional<Trainer> findByName(String name);

    Optional<Trainer> findByDni(Long dni);


    Set<Trainer> findByIdIn(List<Integer> ids);

    default Set<Trainer> findListByIds(List<Integer> ids) {
        Set<Trainer> trainer = findByIdIn(ids);
        if (trainer.size() != ids.size()) throw new NotFoundException(TRAINER_NOT_FOUND);
        return trainer;
    }

}
