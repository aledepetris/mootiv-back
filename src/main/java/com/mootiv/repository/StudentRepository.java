package com.mootiv.repository;

import com.mootiv.domain.persona.Student;
import com.mootiv.error.exception.NotFoundException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import static com.mootiv.error.ApiMootivErrors.STUDENT_NOT_FOUND;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findByName(String name);

    Set<Student> findByIdIn(List<Integer> ids);

    default Set<Student> findListByIds(List<Integer> ids) {
        Set<Student> student = findByIdIn(ids);
        if (student.size() != ids.size()) throw new NotFoundException(STUDENT_NOT_FOUND);
        return student;
    }

}
